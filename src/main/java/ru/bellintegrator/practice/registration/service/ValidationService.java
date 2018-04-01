package ru.bellintegrator.practice.registration.service;


import org.springframework.validation.BindingResult;
import ru.bellintegrator.practice.response.RequestProcessingException;

public interface ValidationService {

    /**
     * Валидация запроса
     */
    void validate(BindingResult result) throws RequestProcessingException;
}
