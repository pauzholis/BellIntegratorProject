package ru.bellintegrator.practice.dictionary.model;

import ru.bellintegrator.practice.user.model.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

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
     * Конструктор для hibernate
     */
    public DocType() {
    }

    public DocType(Integer code, String name, Document document) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
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
}
