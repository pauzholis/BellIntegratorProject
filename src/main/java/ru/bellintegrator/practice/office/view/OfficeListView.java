package ru.bellintegrator.practice.office.view;

/**
 * Данные ответа формирования списка оффисов
 */
public class OfficeListView {
    public long id;
    public String name;
    public boolean isActive;

    public OfficeListView() {
    }

    public OfficeListView(long id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }
}
