package ru.bellintegrator.practice.office.dao;

import org.springframework.data.repository.CrudRepository;
import ru.bellintegrator.practice.office.model.Office;

/**
 * DAO для работы с оффисами
 */
public interface OfficeDao extends CrudRepository<Office, Long> {

    /**
     * Удаление оффиса по id.
     */
    boolean deleteOfficeById(Long id);
}
