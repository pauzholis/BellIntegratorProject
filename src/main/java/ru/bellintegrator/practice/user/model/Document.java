package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.dictionary.model.DocType;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

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
     * Идентификатор типа документа
     */
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id")
    private DocType docType;

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

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
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
