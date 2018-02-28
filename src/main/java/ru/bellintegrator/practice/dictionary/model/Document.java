package ru.bellintegrator.practice.dictionary.model;

import ru.bellintegrator.practice.user.model.*;
import javax.persistence.*;
import java.util.*;

/**
 * Документ
 */
@Entity
@Table(name = "Document")
public class Document {
    /**
     * Идентификатор документа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Идентификатор типа документа
     */
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id")
    private DocType docType;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "number")
    private Integer number;

    /**
     * Дата окончания активности сообщения для отправки пользователю
     */
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    /**
     * Пользователь
     */
    @OneToOne(mappedBy = "Document", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    /**
     * Конструктор для hibernate
     */
    public Document() {
    }

    public Document(DocType docType, Integer number, Date date, User user) {
        this.docType = docType;
        this.number = number;
        this.date = date;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
