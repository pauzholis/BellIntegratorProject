package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeFilter;

import java.util.List;

/**
 * DAO для работы с оффисами
 */
public interface OfficeDao {

    /**
     * Удаление оффиса по id.
     */
    void deleteById(Long id);

    /**
     * Получение организаций
     */
    List<Office> list(OfficeFilter officeFilter);

    /**
     * Получение объекта Office по первичному ключу.
     */
    Office getById(Long id);

    /**
     * Сохранение нового оффиса
     */
    void save(Office office);
}
