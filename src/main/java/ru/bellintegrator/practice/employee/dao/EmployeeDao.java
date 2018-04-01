package ru.bellintegrator.practice.employee.dao;

import ru.bellintegrator.practice.employee.model.Employee;
import ru.bellintegrator.practice.employee.view.EmployeeFilter;

import java.util.List;

/**
 * DAO для работы с работниками
 */
public interface EmployeeDao {

    /**
     * Получение работника по идентификатору.
     */
    Employee getById(Long id);

    /**
     * Сохранение нового работника
     */
    void save(Employee employee);

    /**
     * Удаление работника по идентификатору.
     */
    void deleteById(Long id);

    /**
     * Получение работников
     */
    List<Employee> list(EmployeeFilter employeeFilter);
}
