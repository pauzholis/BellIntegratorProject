package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationListView;

import java.util.List;

/**
 * Сервис для работы с организациями
 */
public interface OrganizationService {

    /**
     * Получить все организации
     */
    List<OrganizationListView> list(String name, boolean isActive);
}
