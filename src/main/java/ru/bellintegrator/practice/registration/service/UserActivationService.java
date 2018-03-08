package ru.bellintegrator.practice.registration.service;

/**
 * Сервис для работы с активацией
 */
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


