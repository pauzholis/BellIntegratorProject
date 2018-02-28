package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.organization.model.*;
import ru.bellintegrator.practice.user.model.*;

import javax.persistence.*;
import java.util.*;

/**
 * Оффис
 */
@Entity
@Table(name = "Office")
public class Office {
    /**
     * Идентификатор оффиса
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
     * Адрес оффиса
     */
    @Column(name = "address")
    private String address;

    /**
     * Идентификатор организации
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * Наименование оффиса
     */
    @Column(name = "name")
    private String name;

    /**
     * Телефон оффиса
     */
    @Column(name = "phone")
    private Integer phone;

    /**
     * Статус активности оффиса
     */
    @Column(name = "isActive")
    private Boolean isActive;

    /**
     * Список пользователей оффиса
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Office", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<>();

    /**
     * Конструктор для hibernate
     */
    public Office() {
    }

    public Office(String address, Organization organization, String name,Integer phone, Boolean isActive) {
        this.address = address;
        this.organization = organization;
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<User> getOffices() {
        return users;
    }

    public void setOffices(Set<User> offices) {
        this.users = offices;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
