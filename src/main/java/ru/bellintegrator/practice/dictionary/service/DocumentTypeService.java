package ru.bellintegrator.practice.dictionary.service;


import ru.bellintegrator.practice.dictionary.view.DocumentTypeView;

import java.util.List;

public interface DocumentTypeService {
    /**
     * Получить перечень видов документов
     */
    List<DocumentTypeView> getAllDocumentType();
}
