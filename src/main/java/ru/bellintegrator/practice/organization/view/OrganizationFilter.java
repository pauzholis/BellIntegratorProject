package ru.bellintegrator.practice.organization.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Отображение данных запроса из списка организаций
 */
public class OrganizationFilter {

    @NotBlank(message = "Поле имя должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное имя не соответствует ограничению по количеству символов")
    public String name;

    @NotBlank(message = "Поле ИНН должно быть заполнено.")
    @Size(min = 12, max = 12, message = "Введенный ИНН не соответствует ограничению по количеству символов")
    public String inn;

    @NotBlank(message = "Поле статус активности должно быть заполнено.")
    public boolean isActive;

    public OrganizationFilter() {
    }

    public OrganizationFilter(String name, String inn, boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }
}
