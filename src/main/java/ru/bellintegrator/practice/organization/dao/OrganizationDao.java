package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с организыциями
 */
public interface OrganizationDao {

    /**
     * Получение объекта Organization по первичному ключу.
     */
    Organization getOrganizationById(Long id);

    /**
     * Сохранение новой организации
     */
    Organization save(Organization org);

    /**
     * Удаление организации по id.
     */
    boolean deleteOrgById(Long id);

    /**
     * Получение организаций
     */
    List<Organization> list(Organization organization);
}