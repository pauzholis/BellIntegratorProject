package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.dictionary.model.*;
import ru.bellintegrator.practice.office.model.*;
import ru.bellintegrator.practice.registration.model.*;

import javax.persistence.*;

/**
 * Пользователь
 */
@Entity
@Table(name = "User")
public class User {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     *  Документ пользователя
     */
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    private Document document;

    /**
     * Запись о гражданстве
     */
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Citizenship citizenship;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Идентификатор оффиса
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Office office;

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
    @Column(name = "phone")
    private Integer phone;

    /**
     * Статус идентификации пользователя
     */
    @Column(name = "isIdentified")
    private Boolean isIdentified;

    /**
     * Акцивация пользователя
     */
    @OneToOne(mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserActivation userActivation;

    /**
     * Конструктор для hibernate
     */
    public User() {
    }

    public User(Document document, Citizenship citizenship, Office office, String firstName, String secondName,
                String middleName, String position, Integer phone, Boolean isIdentified, UserActivation userActivation) {
        this.document = document;
        this.citizenship = citizenship;
        this.office = office;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.userActivation = userActivation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public UserActivation getUserActivation() {
        return userActivation;
    }

    public void setUserActivation(UserActivation userActivation) {
        this.userActivation = userActivation;
    }
}
