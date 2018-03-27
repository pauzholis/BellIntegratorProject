package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationFilter;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;
import java.util.Map;

/**
 * Сервис для работы с организациями
 */
public interface OrganizationService {

    /**
     * Получить все организации
     */
    List<OrganizationView> list(OrganizationFilter organizationFilter) throws RequestProcessingException;

    /**
     * Обнавление организации
     */
    void updateOrg(OrganizationView orgView);

    /**
     * Добавление новой организации
     */
    String saveOrg(OrganizationView orgView);

    /**
     * Удаление организации.
     */
    void deleteOrg(Map<String, Long> id);
}
