package ru.bellintegrator.practice.registration.model;

import javax.persistence.*;

/**
 * Регистрационные данные
 */
@Entity
@Table(name = "Registration_Data")
public class RegistrationData {
    /**
     * Идентификатор регистрационных данных
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Логин
     */
    @Column(name = "login")
    private String login;

    /**
     * Пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * Имя регистрирующегося пользователя
     */
    @Column(name = "name")
    private String name;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    public RegistrationData() {
    }

    public RegistrationData(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
