package ru.bellintegrator.practice.response;

/**
 * Исключение обработки запроса
 */
public class RequestProcessingException extends Exception {
    public RequestProcessingException(String message) {
        super(message);
    }
}
