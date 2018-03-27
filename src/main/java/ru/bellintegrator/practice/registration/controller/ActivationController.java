package ru.bellintegrator.practice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.user.service.UserService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class ActivationController {
    private final UserService userService;

    @Autowired
    public ActivationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/activation/{hash}", method = RequestMethod.GET)
    public void checkHashValid(@PathVariable("hash") String hash) {
        userService.selectUserActive(hash);
    }
}
