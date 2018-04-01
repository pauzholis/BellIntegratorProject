package ru.bellintegrator.practice.registration.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Регистрационные данные пользователя
 */
@Entity
@Table(name = "registration_data")
public class User {

    /**
     * Идентификатор регистрациооных данных пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Логин пользователя
     */
    @Column(name = "login")
    private String login;

    /**
     * Пароль пользователя
     */
    @Column(name = "user_password")
    private String password;

    /**
     * Почта пользователя
     */
    @Column(name = "email")
    private String email;

    /**
     * Имя пользователя
     */
    @Column(name = "name")
    private String name;

    /**
     * Статус регистрации
     */
    @Column(name = "active")
    private Boolean isActive;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Акцивация пользователя
     */
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserActivation userActivation;

    /**
     * Пустой конструктор для hibernate
     */
    public User() {
    }

    public User(String login, String password, String name, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.isActive = false;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserActivation getUserActivation() {
        return userActivation;
    }

    public void setUserActivation(UserActivation userActivation) {
        this.userActivation = userActivation;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
