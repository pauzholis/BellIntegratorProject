package ru.bellintegrator.practice.dictionary.model;

import ru.bellintegrator.practice.user.model.Document;

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
    @Column(name = "code", length = 3)
    private String code;

    /**
     * Имя регистрирующегося пользователя
     */
    @Column(name = "name")
    private String name;

    /**
     * Список документов одного типа
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Document> documents = new HashSet<>();

    /**
     * Конструктор для hibernate
     */
    public DocType() {
    }

    public DocType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}
