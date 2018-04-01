package ru.bellintegrator.practice.registration.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Отображение данных запроса для входа в аккаунт
 */
public class LoginRequestView {

    @NotBlank(message = "Поле логин обязательно для ввода")
    @Size(min = 2, max = 255, message = "Введенный логин не корректен")
    public String login;

    @NotBlank(message = "Поле пароль обязательно для ввода")
    public String password;

    public LoginRequestView() {
    }

    public LoginRequestView(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
