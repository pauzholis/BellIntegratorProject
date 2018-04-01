package ru.bellintegrator.practice.employee.view;

/**
 * Данные ответа метода list
 */
public class EmployeeListResponseView {
    public Long id;
    public String firstName;
    public String secondName;
    public String middleName;
    public String position;

    public EmployeeListResponseView() {
    }

    public EmployeeListResponseView(Long id, String firstName, String secondName, String middleName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
    }
}
