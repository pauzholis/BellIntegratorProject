package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;
import java.util.Map;

/**
 * Сервис для работы с организациями
 */
public interface OrganizationService {

    /**
     * Получить все организации
     */
    List<OrganizationListView> list(String name, boolean isActive);

    /**
     * Обнавление организации
     */
    String updateOrg(OrganizationView orgView);

    /**
     * Добавление новой организации
     */
    String saveOrg(OrganizationView orgView);

    /**
     * Удаление организации.
     */
    String deleteOrg(Map<String, Long> id);
}
