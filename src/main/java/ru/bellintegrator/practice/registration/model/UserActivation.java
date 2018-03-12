package ru.bellintegrator.practice.registration.model;

import ru.bellintegrator.practice.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Активация пользователя
 */
@Entity
@Table(name = "User_Activation")
public class UserActivation {
    /**
     * Идентификатор активации пользователя
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
     * Строка активации пользователя
     */
    @Column(name = "hash")
    private String hash;

    /**
     * Пользователь
     */
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Конструктор для hibernate
     */
    public UserActivation() {
    }

    public UserActivation(User user, String hash) {
        this.user = user;
        this.hash = hash;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
