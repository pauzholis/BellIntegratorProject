package ru.bellintegrator.practice.employee.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Отображение данных запроса из списка работников
 */
public class EmployeeFilter {

    @NotBlank(message = "Поле идентификатор оффиса должно быть заполнено.")
    public String officeId;

    @NotBlank(message = "Поле имя должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное имя не соответствует ограничению по количеству символов")
    public String firstName;

    @NotBlank(message = "Поле фамилия должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенная фамилия не соответствует ограничению по количеству символов")
    public String lastName;

    @NotBlank(message = "Поле отчество должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное отчество не соответствует ограничению по количеству символов")
    public String middleName;

    @NotBlank(message = "Поле должность должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенная должность не соответствует ограничению по количеству символов")
    public String position;

    @NotBlank(message = "Поле код документа должно быть заполнено.")
    @Size(max = 3, message = "Введенная должность не соответствует ограничению по количеству символов")
    public String docCode;

    @NotBlank(message = "Поле код документа должно быть заполнено.")
    @Size(min = 3, max = 3, message = "Введенная должность не соответствует ограничению по количеству символов")
    public String citizenshipCode;

    public EmployeeFilter() {
    }

    public EmployeeFilter(String officeId, String firstName, String lastName, String middleName, String position,
                          String docCode, String citizenshipCode) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
    }
}
