package ru.bellintegrator.practice.office.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Отображение параметров оффиса
 */
public class OfficeView {

    @NotBlank(message = "Поле id должно быть заполнено.")
    public long id;

    @NotBlank(message = "Поле имя должно быть заполнено.")
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

    public OfficeView() {
    }

    public OfficeView(long id, String name, String address, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
