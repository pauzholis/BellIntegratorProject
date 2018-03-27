package ru.bellintegrator.practice.registration.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.registration.service.RegistrationDataService;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

/**
 * {@inheritDoc}
 */
@Service
public class RegistrationDataServiceImpl implements RegistrationDataService {

    @Override
    @Transactional(propagation = REQUIRES_NEW)
    public void registerUser(String login, String password, String name) {
    }
}
