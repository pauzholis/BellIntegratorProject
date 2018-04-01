package ru.bellintegrator.practice.office.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Данные запроса списка оффисов
 */
public class OfficeFilter {

    @NotBlank(message = "Поле идентификатор организации должно быть заполнено")
    public String orgId;

    @NotBlank(message = "Поле наименование должно быть заполнено")
    @Size(min = 2, max = 255, message = "Введенное имя не соответствует ограничению по количеству символов")
    public String name;

    @NotBlank(message = "Поле телефон должно быть заполнено")
    @Size(min = 6, max = 16, message = "Введенный телефон не соответствует ограничению по количеству символов")
    public String phone;

    @NotBlank(message = "Поле статус активоности должно быть заполнено")
    public boolean isActive;

    public OfficeFilter() {
    }

    public OfficeFilter(String orgId, String name, String phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.phone = phone;
        this.isActive = isActive;
    }
}
