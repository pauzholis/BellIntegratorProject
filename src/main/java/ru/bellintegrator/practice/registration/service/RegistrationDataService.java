package ru.bellintegrator.practice.registration.service;

/**
 * Сервис для работы с регистрацией пользователя
 */
public interface RegistrationDataService {

    /**
     * Регистрация пользователя
     */
    void registerUser(String login, String password, String name);


}
