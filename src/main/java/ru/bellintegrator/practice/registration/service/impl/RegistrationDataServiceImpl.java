package ru.bellintegrator.practice.registration.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.registration.service.RegistrationDataService;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

/**
 * {@inheritDoc}
 */
@Service
public class RegistrationDataServiceImpl implements RegistrationDataService {
    private static final String ACTIVATION_URL = "%shttp://localhost:8080/activation/%s";
    private static final String ACTIVATION_MESSAGE = "Для активации вашего аккаунта пройдите по этой ссылке ";
//    private final RegistrationDataDao registrationDataDao;
//    private final NotificationDao notificationDao;

    @Override
    @Transactional(propagation = REQUIRES_NEW)
    public void registerUser(String login, String password, String name) {


    }
}
