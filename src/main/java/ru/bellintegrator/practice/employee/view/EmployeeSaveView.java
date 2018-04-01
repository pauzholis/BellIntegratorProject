package ru.bellintegrator.practice.employee.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Отображение данных для сохранения работника
 */
public class EmployeeSaveView {

    @NotBlank(message = "Поле имя должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное имя не соответствует ограничению по количеству символов")
    public String firstName;

    @NotBlank(message = "Поле фамилия должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенная фамилия не соответствует ограничению по количеству символов")
    public String secondName;

    @NotBlank(message = "Поле отчество должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное отчество не соответствует ограничению по количеству символов")
    public String middleName;

    @NotBlank(message = "Поле должность должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенная должность не соответствует ограничению по количеству символов")
    public String position;

    @NotBlank(message = "Поле телефон должно быть заполнено.")
    @Size(min = 2, max = 16, message = "Введенный телефон не соответствует ограничению по количеству символов")
    public String phone;

    @NotBlank(message = "Поле код документа должно быть заполнено.")
    @Size(min = 3, max = 3, message = "Введенный код документа не соответствует ограничению по количеству " +
            "символов")
    public String docCode;

    @NotBlank(message = "Поле наименование документа должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное наименование документа не соответствует ограничению по количеству " +
            "символов")
    public String docName;

    @NotBlank(message = "Поле номер документа должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенный номер документа не соответствует ограничению по количеству символов")
    public String docNumber;

    @NotBlank(message = "Поле дата документа должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенный номер документа не соответствует ограничению по количеству символов")
    public String docDate;

    @NotBlank(message = "Поле гражданство должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенное гражданство не соответствует ограничению по количеству символов")
    public String citizenshipName;

    @NotBlank(message = "Поле код гражданства должно быть заполнено.")
    @Size(min = 2, max = 255, message = "Введенный код гражданства не соответствует ограничению по количеству символов")
    public String citizenshipCode;

    @NotBlank(message = "Поле статус идентификации должно быть заполнено.")
    public boolean isIdentified;

    public EmployeeSaveView() {
    }

    public EmployeeSaveView(String firstName, String secondName, String middleName, String position, String phone,
                            String docCode, String docName, String docNumber, String docDate, String citizenshipName,
                            String citizenshipCode, boolean isIdentified) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }
}
