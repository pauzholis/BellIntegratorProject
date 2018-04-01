package ru.bellintegrator.practice.registration.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Отображение данных запроса регистрации
 */
public class UserRegistrationRequestView {

    @NotBlank(message = "Поле логин должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенный логин не соответствует ограничению по количеству символов")
    public String login;

    @NotBlank(message = "Поле пароль должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенный пароль не соответствует ограничению по количеству символов")
    public String password;

    @NotBlank(message = "Поле имя должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное имя не соответствует ограничению по количеству символов")
    public String name;

    @NotBlank(message = "Некорректный адресс почты.")
    @Size(min = 2, max = 255, message = "Слишком длинный адресс почты")
    public String email;

    public UserRegistrationRequestView() {
    }

    public UserRegistrationRequestView(String login, String password, String name, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}