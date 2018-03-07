package ru.bellintegrator.practice.registration.service;

/**
 * Сервис для получения хэша строки
 */
public interface DigestService {

    /**
     * Получить хэш строки в формате base64
     */
    String hash(String source);
}