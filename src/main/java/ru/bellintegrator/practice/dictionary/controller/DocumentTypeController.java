package ru.bellintegrator.practice.dictionary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dictionary.service.DocumentTypeService;
import ru.bellintegrator.practice.dictionary.view.DocumentTypeView;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class DocumentTypeController {
    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @RequestMapping(value = "/docs", method = {RequestMethod.GET})
    public List<DocumentTypeView> getAllDocumentType() {
        return documentTypeService.getAllDocumentType();
    }
}
