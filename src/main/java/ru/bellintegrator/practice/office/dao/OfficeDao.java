package ru.bellintegrator.practice.office.dao;

/**
 * DAO для работы с оффисами
 */
public interface OfficeDao {

    /**
     * Удаление оффиса по id.
     */
    boolean deleteOfficeById(Long id);
}
