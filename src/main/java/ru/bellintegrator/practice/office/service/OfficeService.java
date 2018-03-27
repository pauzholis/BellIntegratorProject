package ru.bellintegrator.practice.office.service;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.Map;

/**
 * Сервис для работы с оффисами
 */
@Repository
public interface OfficeService {

    /**
     * Удаление организации.
     */
    void deleteOffice(Map<String, Long> id);

    /**
     * Добавление нового оффиса
     */
    String saveOffice(OrganizationView orgView);
}
