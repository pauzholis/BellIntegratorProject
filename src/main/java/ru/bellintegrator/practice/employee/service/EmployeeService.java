package ru.bellintegrator.practice.employee.service;

import ru.bellintegrator.practice.employee.view.EmployeeFilter;
import ru.bellintegrator.practice.employee.view.EmployeeListResponseView;
import ru.bellintegrator.practice.employee.view.EmployeeSaveView;
import ru.bellintegrator.practice.employee.view.EmployeeView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;

/**
 * Сервис для работы с работниками
 */
public interface EmployeeService {

    /**
     * Получить всех работников
     */
    List<EmployeeListResponseView> list(EmployeeFilter employeeFilter) throws RequestProcessingException;

    /**
     * Обнавление данных о работнике
     */
    void updateEmployee(EmployeeView employeeView);

    /**
     * Удаление данных работника.
     */
    void deleteEmployee(Long id);

    /**
     * Получить работника по идентификатору
     */
    EmployeeView getEmployeeById(Long id);

    /**
     * Сохранить данные о новом работнике
     */
    void save(EmployeeSaveView employeeSaveView);
}
