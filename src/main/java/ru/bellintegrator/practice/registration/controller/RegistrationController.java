package ru.bellintegrator.practice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.registration.model.RegistrationData;
import ru.bellintegrator.practice.registration.service.RegistrationDataService;
import ru.bellintegrator.practice.registration.view.RegisterRequestView;
import ru.bellintegrator.practice.registration.view.RegisterResultView;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class RegistrationController {

    private final RegistrationDataService registrationDataService;

    @Autowired
    public RegistrationController(RegistrationDataService registrationDataService) {
        this.registrationDataService = registrationDataService;
    }


    /**
     * Результат регистрации
     */
    @RequestMapping(value = "/register", method = {POST})
    public RegisterResultView register(
            @RequestBody
                    RegisterRequestView registrationData) {
        RegisterResultView response = new RegisterResultView();
        response.result = "success";
        return response;
    }

    /**
     * Страница регистрации
     */
    @RequestMapping(value = {"/registration"})
    public String showRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationData());
        return "/registration";
    }

    /**
     * Страница добавления пользователя
     */
    @RequestMapping(value = "/registration/submit", method = RequestMethod.POST)
    public String registration(@ModelAttribute RegistrationData registrationData) {
        String login = registrationData.getLogin();
        String password = registrationData.getPassword();
        String name = registrationData.getName();
        registrationDataService.registerUser(login, password, name);
        return "/activation";
}
