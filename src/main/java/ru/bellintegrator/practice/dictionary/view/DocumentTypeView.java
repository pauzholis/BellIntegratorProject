package ru.bellintegrator.practice.dictionary.view;


public class DocumentTypeView {
    public String name;
    public String code;

    public DocumentTypeView() {
    }

    public DocumentTypeView(String code, String name) {
        this.name = name;
        this.code = code;
    }
}