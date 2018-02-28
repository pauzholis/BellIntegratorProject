package ru.bellintegrator.practice.dictionary.model;

import ru.bellintegrator.practice.user.model.*;

import javax.persistence.*;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
