package ru.bellintegrator.practice.organization.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Отображение данных для обновления организации
 */
public class OrganizationUpdateView {

    @NotBlank(message = "Поле id должно быть заполнено.")
    public long id;

    @NotBlank(message = "Поле имя должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное имя не соответствует ограничению по количеству символов")
    public String name;

    @NotBlank(message = "Поле полное имя должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное полное имя не соответствует ограничению по количеству символов")
    public String fullName;

    @NotBlank(message = "Поле ИНН должно быть заполнено.")
    @Size(min = 12, max = 12, message = "Введенный ИНН не соответствует ограничению по количеству символов")
    public String inn;

    @NotBlank(message = "Поле КПП должно быть заполнено.")
    @Size(min = 9, max = 9, message = "Введенный КПП не соответствует ограничению по количеству символов")
    public String kpp;

    @NotBlank(message = "Поле адрес должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенный адрес не соответствует ограничению по количеству символов")
    public String address;

    @NotBlank(message = "Поле телефон должно быть заполнено.")
    @Size(min = 16, max = 16, message = "Введенный телефон не соответствует ограничению по количеству символов")
    public String phone;

    @NotBlank(message = "Поле статус активности должно быть заполнено.")
    public boolean isActive;

    public OrganizationUpdateView() {
    }

    public OrganizationUpdateView(long id, String name, String fullName, String inn, String kpp, String address, String phone,
                                  boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
