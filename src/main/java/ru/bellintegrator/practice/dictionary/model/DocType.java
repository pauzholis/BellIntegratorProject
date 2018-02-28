package ru.bellintegrator.practice.dictionary.model;

import javax.persistence.*;

/**
 * Тип документа
 */
@Entity
@Table(name = "Doc_Type")
public class DocType {
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
     * Код документа
     */
    @Column(name = "code")
    private Integer code;

    /**
     * Имя регистрирующегося пользователя
     */
    @Column(name = "name")
    private String name;

    /**
     * Документ
     */
    @OneToOne(mappedBy = "Doc_Type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Document document;

    /**
     * Конструктор для hibernate
     */
    public DocType() {
    }

    public DocType(Integer code, String name, Document document) {
        this.code = code;
        this.name = name;
        this.document = document;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
