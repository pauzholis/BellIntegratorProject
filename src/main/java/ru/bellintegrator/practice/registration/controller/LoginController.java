package ru.bellintegrator.practice.registration.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.registration.view.LoginRequestView;
import ru.bellintegrator.practice.registration.view.LoginResultView;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class LoginController {

    /**
     * Входные данные аккаунта
     */
    @RequestMapping(value = "/login", method = {POST})
    public LoginResultView login(
            @RequestBody
                    LoginRequestView loginData) {
        LoginResultView response = new LoginResultView();
        response.result = "success";
        return response;
    }
}
