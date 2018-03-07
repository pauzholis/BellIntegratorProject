package ru.bellintegrator.practice.registration.service.impl;


import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.registration.service.UserActivationService;

import java.util.UUID;
@Service
public class UserActivationServiceImpl implements UserActivationService{

    /**
     * Генерация кода активации
     */
    @Override
    public String generateActivationCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void selectUserActive(String hash) {

    }
}
