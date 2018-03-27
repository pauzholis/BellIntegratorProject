package ru.bellintegrator.practice.registration.view;

/**
 * Отображение данных запроса регистрации
 */
public class UserRegistrationRequestView {
    public String login;
    public String password;
    public String name;
    public String email;

    public UserRegistrationRequestView() {
    }

    public UserRegistrationRequestView(String login, String password, String name, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}