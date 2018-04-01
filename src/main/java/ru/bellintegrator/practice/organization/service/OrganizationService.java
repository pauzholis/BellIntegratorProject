package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationFilter;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;

/**
 * Сервис для работы с организациями
 */
public interface OrganizationService {

    /**
     * Получить все организации
     */
    List<OrganizationListView> list(OrganizationFilter organizationFilter) throws RequestProcessingException;

    /**
     * Обнавление организации
     */
    void updateOrg(OrganizationUpdateView orgView);

    /**
     * Удаление организации.
     */
    void deleteOrg(Long id);

    /**
     * Получить организации по идентификатору
     */
    OrganizationUpdateView getOrgById(Long id);

    /**
     * Сохранение организации
     */
    void save(OrganizationSaveView view);
}
