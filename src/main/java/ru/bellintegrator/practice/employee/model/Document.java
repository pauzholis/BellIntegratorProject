package ru.bellintegrator.practice.employee.model;

import ru.bellintegrator.practice.dictionary.model.DocumentType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
    private String number;

    /**
     * Дата начала действия документа
     */
    @Column(name = "date", length = 9)
    private String date;

    /**
     * Пользователь
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employee employee;

    /**
     * Идентификатор типа документа
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_type_id")
    private DocumentType documentType;

    /**
     * Конструктор для hibernate
     */
    public Document() {
    }

    public Document(DocumentType documentType, String number, String date) {
        this.documentType = documentType;
        this.number = number;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
