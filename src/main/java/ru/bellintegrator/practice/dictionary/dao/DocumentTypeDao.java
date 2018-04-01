package ru.bellintegrator.practice.dictionary.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.dictionary.model.DocumentType;

public interface DocumentTypeDao extends JpaRepository<DocumentType, Long> {
    /**
     * Поиск типа документа по названию
     */
    DocumentType findByName(String name);

    /**
     * Поиск типа документа по коду
     */
    DocumentType findByCode(String code);
}
