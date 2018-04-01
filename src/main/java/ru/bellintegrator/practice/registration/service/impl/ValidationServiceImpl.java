package ru.bellintegrator.practice.registration.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import ru.bellintegrator.practice.registration.service.ValidationService;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.Iterator;
import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public void validate(BindingResult result) throws RequestProcessingException {
        if (result.hasErrors()) {
            List<ObjectError> error = result.getAllErrors();
            Iterator<ObjectError> errorIterator = error.iterator();
            StringBuilder errorMessage = new StringBuilder();
            while (errorIterator.hasNext()) {
                errorMessage.append(" ").append(errorIterator.next().getDefaultMessage());
                if (!errorIterator.hasNext()) {
                    errorMessage.append(".");
                } else {
                    errorMessage.append(",");
                }
            }
            throw new RequestProcessingException("Вы не правильно заполнили форму регистрации:" + errorMessage);
        }
    }
}
