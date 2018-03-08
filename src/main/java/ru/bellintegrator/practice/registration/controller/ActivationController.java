package ru.bellintegrator.practice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.registration.service.UserActivationService;

@RestController
@RequestMapping(value = "/api")
public class ActivationController {
    private final UserActivationService userActivationService;

    @Autowired
    public ActivationController(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @RequestMapping(value = "activation?code={hash}", method = RequestMethod.GET)
    public String activateUser(@PathVariable("code") String hash) {

        userActivationService.selectUserActive(hash);
        return "index";
    }
}
