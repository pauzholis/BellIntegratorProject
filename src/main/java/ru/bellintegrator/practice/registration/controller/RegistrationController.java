package ru.bellintegrator.practice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.registration.view.UserRegistrationRequestView;
import ru.bellintegrator.practice.user.service.UserService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public void registrationUser(@RequestBody UserRegistrationRequestView user) {
        userService.registerUser(user.login, user.password, user.name, user.email);
    }
}