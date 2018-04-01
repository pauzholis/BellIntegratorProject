package ru.bellintegrator.practice.organization.view;

/**
 * Отображение данных
 */
public class OrganizationListView {
    public long id;
    public String name;
    public boolean isActive;

    public OrganizationListView() {
    }

    public OrganizationListView(long id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }
}
