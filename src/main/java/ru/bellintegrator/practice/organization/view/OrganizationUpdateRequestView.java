package ru.bellintegrator.practice.organization.view;

/**
 * Входные данные запроса на обновление организации
 */
public class OrganizationUpdateRequestView {
    public long id;
    public String name;
    public String fullName;
    public String inn;
    public String kpp;
    public String address;
    public int phone;
    public boolean isActive;
}
