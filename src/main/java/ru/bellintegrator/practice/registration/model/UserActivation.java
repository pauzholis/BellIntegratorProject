package ru.bellintegrator.practice.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "user_activation")
public class UserActivation {

    /**
     * Идентификатор акцивации пользователя
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Пользователь
     */
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_data_id")
    private User user;

    /**
     * Строка активации пользователя
     */
    @Column(name = "message_hash")
    private String hash;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Пустой конструктор для hibernate
     */
    public UserActivation() {
    }

    public UserActivation(User User, String hash) {
        this.user = User;
        this.hash = hash;
    }

    public User getUser() {
        return user;
    }

    public String getHash() {
        return hash;
    }

    public void setEmployee(User User) {
        this.user = User;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}