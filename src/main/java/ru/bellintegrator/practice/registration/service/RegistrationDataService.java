package ru.bellintegrator.practice.registration.service;

public interface RegistrationDataService {

    /**
     * Регистрация пользователя
     */
    void registerUser(String login, String password, String name);


}
