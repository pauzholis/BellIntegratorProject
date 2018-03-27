package ru.bellintegrator.practice.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Сообщение пользователю
 */
@Entity
@Table(name = "Notification")
public class Notification {
    /**
     * Идентификатор сообщения
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
     * Адресс для отправки сообщения
     */
    @Column(name = "address")
    private String address;

    /**
     * Текст сообщения
     */
    @Column(name = "massage")
    private String massage;

    public Notification() {
    }

    public Notification(String address, String massage) {
        this.address = address;
        this.massage = massage;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
