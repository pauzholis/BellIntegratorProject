package ru.bellintegrator.practice.office.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Данные запроса сохранения пользователя
 */
public class OfficeSaveView {

    @NotBlank(message = "Поле наименование должно быть заполнено")
    @Size(min = 2, max = 255, message = "Введенное имя не соответствует ограничению по количеству символов")
    public String name;

    @NotBlank(message = "Поле адрес должно быть заполнено.")
    @Size(min = 2, max = 50, message = "Введенный адрес не соответствует ограничению по количеству символов")
    public String address;

    @NotBlank(message = "Поле телефон должно быть заполнено.")
    @Size(min = 2, max = 16, message = "Введенный телефон не соответствует ограничению по количеству символов")
    public String phone;

    @NotBlank(message = "Поле статус активности должно быть заполнено.")
    public boolean isActive;

    public OfficeSaveView() {
    }

    public OfficeSaveView(String name, String address, String phone, boolean isActive) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
