package ru.bellintegrator.practice.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dictionary.model.Country;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.registration.model.Notification;
import ru.bellintegrator.practice.registration.model.RegistrationData;
import ru.bellintegrator.practice.registration.model.UserActivation;
import ru.bellintegrator.practice.user.dao.NotificationDao;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.Document;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.service.UserService;

import java.util.List;
import java.util.UUID;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class UserServiceImpl implements UserService {

    private static final String ACTIVATION_URL = "%shttp://localhost:8888/api/activation/%s";
    private static final String ACTIVATION_MESSAGE = "Для активации вашего аккаунта пройдите по этой ссылке ";
    private final UserDao userDao;
    private final Notification notification;
    private final NotificationDao notificationDao;
    private final PasswordEncoder digestService;
    private final RegistrationData registrationData;

    @Autowired
    public UserServiceImpl(UserDao userDao, Notification notification, NotificationDao notificationDao,
                           PasswordEncoder digestService, RegistrationData registrationData) {
        this.userDao = userDao;
        this.notification = notification;
        this.notificationDao = notificationDao;
        this.digestService = digestService;
        this.registrationData = registrationData;
    }

    /**
     * Получить пользователя по id
     */
    @Override
    @Transactional
    public User getUserById(long id) {
        return userDao.findOne(id);
    }

    /**
     * Получить пользователя по логину
     */
    @Override
    @Transactional
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    /**
     * Получить всех пользователей
     */
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    /**
     * Удалить пользователя по логину
     */
    @Override
    @Transactional
    public void remove(String login) {
        userDao.deleteByLogin(login);
    }

    /**
     * Сохранить нового пользователя
     */
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    /**
     * Генерация кода активации
     */
    private String generateActivationCode() {
        return UUID.randomUUID().toString();
    }

    @Transactional(propagation = REQUIRES_NEW)
    private UserActivation createUserActivation(User user, String hash) {
        UserActivation userActivation = new UserActivation();
        user.setUserActivation(userActivation);
        userDao.save(user);
        return userActivation;
    }

    private void createNotification(String address, String activationCode) {
        Notification notification = new Notification(address, String.format(ACTIVATION_URL, ACTIVATION_MESSAGE,
                activationCode));
        notificationDao.save(notification);
    }

    @Override
    @Transactional(propagation = REQUIRES_NEW)
    public void registerUser(String login, String password, String name, String email) {
        User user = new User();
        String activationCode = generateActivationCode();
        registrationData.setPassword(digestService.encode(registrationData.getPassword()));
        UserActivation userActivation = createUserActivation(user, activationCode);
        user.setUserActivation(userActivation);
        createNotification(notification.getAddress(), activationCode);
        save(user);
    }



}
