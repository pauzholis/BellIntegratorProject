package ru.bellintegrator.practice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.registration.service.ValidationService;
import ru.bellintegrator.practice.registration.view.LoginRequestView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import javax.validation.Valid;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class LoginController {
    private final AuthenticationManager am;
    private final ValidationService validationService;

    @Autowired
    public LoginController(AuthenticationManager am, ValidationService validationService) {
        this.am = am;
        this.validationService = validationService;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public void login(@Valid @RequestBody LoginRequestView loginRequestView,
                      BindingResult result) throws RequestProcessingException {
        validationService.validate(result);
        org.springframework.security.core.Authentication authentication = am.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestView.login, loginRequestView.password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        authentication.getDetails();
    }
}
