package ru.bellintegrator.practice.employee.model;

import org.hibernate.annotations.Type;
import ru.bellintegrator.practice.dictionary.model.Country;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.registration.model.UserActivation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * Пользователь
 */
@Entity
@Table(name = "Employee")
public class Employee {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * Отчество пользователя
     */
    @Column(name = "middle_name")
    private String middleName;

    /**
     * Должность пользователя
     */
    @Column(name = "position")
    private String position;

    /**
     * Телефон пользователя
     */
    @Column(name = "phone", length = 16)
    private String phone;

    /**
     * Статус идентификации пользователя
     */
    @Type(type = "true_false")
    @NotNull(message = "NOT_NULL")
    @Column(name = "isIdentified", nullable = false)
    private Boolean isIdentified;

    /**
     * Статус регистрации
     */
    @Column(name = "active")
    private Boolean isActive;


    /**
     * Документ пользователя
     */
    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Document document;

    /**
     * Запись о гражданстве
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    /**
     * Оффис
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Активация пользователя
     */
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserActivation userActivation;

    /**
     * Конструктор для hibernate
     */
    public Employee() {
    }

    public Employee(Document document, Country country, Office office, String firstName, String secondName,
                    String middleName, String position, String phone, Boolean isIdentified) {
        this.document = document;
        this.country = country;
        this.office = office;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public void setUserActivation(UserActivation userActivation) {
        this.userActivation = userActivation;
    }

    public UserActivation getUserActivation() {
        return userActivation;
    }
}
