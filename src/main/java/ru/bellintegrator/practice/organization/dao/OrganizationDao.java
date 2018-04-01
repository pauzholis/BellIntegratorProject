package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationFilter;

import java.util.List;

/**
 * DAO для работы с организыциями
 */
public interface OrganizationDao {

    /**
     * Получение объекта Organization по первичному ключу.
     */
    Organization getById(Long id);

    /**
     * Сохранение новой организации
     */
    void save(Organization org);

    /**
     * Удаление организации по id.
     */
    void deleteById(Long id);

    /**
     * Получение организаций
     */
    List<Organization> list(OrganizationFilter organizationFilter);
}
