package ru.bellintegrator.practice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.registration.service.UserService;
import ru.bellintegrator.practice.registration.service.ValidationService;
import ru.bellintegrator.practice.registration.view.UserRegistrationRequestView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import javax.validation.Valid;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class RegistrationController {

    private final UserService userService;
    private final ValidationService validationService;

    @Autowired
    public RegistrationController(UserService userService, ValidationService validationService) {
        this.userService = userService;
        this.validationService = validationService;
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public void registrationUser(@Valid @RequestBody UserRegistrationRequestView user,
                                 BindingResult result) throws RequestProcessingException {
        validationService.validate(result);
        userService.registerUser(user.login, user.password, user.name, user.email);
    }
}