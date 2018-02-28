package ru.bellintegrator.practice.organization.model;

import ru.bellintegrator.practice.office.model.*;
import javax.persistence.*;
import java.util.*;

/**
 * Организация
 */
@Entity
@Table(name = "Organization")
public class Organization {
    /**
     * Идентификатор организации
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
     * Сокращенное наименование организации
     */
    @Column(name = "name")
    private String name;

    /**
     * Полное наименование организации
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * ИНН Организации
     */
    @Column(name = "inn")
    private Long inn;

    /**
     * КПП Организации
     */
    @Column(name = "kpp")
    private Integer kpp;

    /**
     * Адрес организации
     */
    @Column(name = "address")
    private String address;

    /**
     * Телефон организации
     */
    @Column(name = "phone")
    private Integer phone;

    /**
     * Статус активности организации
     */
    @Column(name = "isActive")
    private Boolean isActive;

    /**
     * Список оффисов орагнизации
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Office> offices = new HashSet<>();

    /**
     * Конструктор для hibernate
     */
    public Organization() {
    }

    public Organization(String name, String fullName, Long inn, Integer kpp, String address, Integer phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Integer getKpp() {
        return kpp;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
