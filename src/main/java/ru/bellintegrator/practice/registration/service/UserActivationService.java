package ru.bellintegrator.practice.registration.service;


public interface UserActivationService {

    /**
     * Генерация кода активации
     */
    String generateActivationCode();

    /**
     * Установка активации пользователя
     */
    void selectUserActive(String hash);
}


