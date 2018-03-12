package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.Map;

/**
 * Сервис для работы с оффисами
 */
public interface OfficeService {

    /**
     * Удаление организации.
     */
    String deleteOffice(Map<String, Long> id);

    /**
     * Добавление нового оффиса
     */
    String saveOffice(OrganizationView orgView);
}
