package ru.bellintegrator.practice.registration.service;


import ru.bellintegrator.practice.registration.model.User;

import java.util.List;

public interface UserService {

    /**
     * Получение пользователя по идентификатору
     */
    User getUserById(long id);

    /**
     * Получение пользователя по адресу почты
     */
    User getUserByLogin(String login);

    /**
     * Получение списка пользователей
     */
    List<User> getAllUsers();

    /**
     * Удалить пользователей
     */
    void remove(String email);

    /**
     * Регистрация пользователя
     */
    void registerUser(String email, String password, String login, String name);

    /**
     * Сохранение пользователя
     */
    void save(User user);

    /**
     * Установка активации пользователя
     */
    void selectUserActive(String email);
}