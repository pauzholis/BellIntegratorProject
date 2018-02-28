package ru.bellintegrator.practice.registration.model;


import ru.bellintegrator.practice.user.model.*;
import javax.persistence.*;

/**
 * Активация пользователя
 */
@Entity
@Table(name = "User_Activation")
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
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Строка активации пользователя
     */
    @Column(name = "hash")
    private String hash;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

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

    public void setId(Long id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
