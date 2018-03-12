package ru.bellintegrator.practice.organization.model;

import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.HashSet;
import java.util.Set;

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
    private String inn;

    /**
     * КПП Организации
     */
    @Column(name = "kpp")
    private String kpp;

    /**
     * Адрес организации
     */
    @Column(name = "address")
    private String address;

    /**
     * Телефон организации
     */
    @Column(name = "phone")
    private String phone;

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

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
