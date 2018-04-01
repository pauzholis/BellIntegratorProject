package ru.bellintegrator.practice.dictionary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dictionary.dao.DocumentTypeDao;
import ru.bellintegrator.practice.dictionary.model.DocumentType;
import ru.bellintegrator.practice.dictionary.service.DocumentTypeService;
import ru.bellintegrator.practice.dictionary.view.DocumentTypeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final DocumentTypeDao documentTypeDao;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDao documentTypeDao) {
        this.documentTypeDao = documentTypeDao;
    }

    @Override
    @Transactional
    public List<DocumentTypeView> getAllDocumentType() {
        List<DocumentType> documentTypes = documentTypeDao.findAll();
        Function<DocumentType, DocumentTypeView> mapDocumentType = d -> {
            DocumentTypeView documentTypeView = new DocumentTypeView();
            documentTypeView.name = d.getName();
            documentTypeView.code = d.getCode();
            return documentTypeView;
        };
        return documentTypes.stream().map(mapDocumentType).collect(Collectors.toList());
    }
}