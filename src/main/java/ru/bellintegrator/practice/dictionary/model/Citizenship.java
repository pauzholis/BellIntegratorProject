package ru.bellintegrator.practice.dictionary.model;

import ru.bellintegrator.practice.user.model.User;
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
 * Гражданство
 */
@Entity
@Table(name = "Citizenship")
public class Citizenship {
    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Код общероссийского класификатора стран мира
     */
    @Column(name = "code")
    private Integer code;

    /**
     * Наименование страны
     */
    @Column(name = "name")
    private String name;

    /**
     * Пользователь
     */
    @OneToOne(mappedBy = "Citizenship", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public Citizenship() {
    }

    public Citizenship(Integer code, String name, User user) {
        this.code = code;
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
