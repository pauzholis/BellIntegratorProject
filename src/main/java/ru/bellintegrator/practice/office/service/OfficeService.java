package ru.bellintegrator.practice.office.service;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeListView;
import ru.bellintegrator.practice.office.view.OfficeSaveView;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;

/**
 * Сервис для работы с оффисами
 */
@Repository
public interface OfficeService {

    /**
     * Удаление организации.
     */
    void deleteOffice(Long id);

    /**
     * Добавление нового оффиса
     */
    void saveOffice(OfficeSaveView officeSaveView);

    /**
     * Обновление оффиса
     */
    void updateOffice(OfficeView officeView);

    /**
     * Получить все организации
     */
    List<OfficeListView> list(OfficeFilter officeFilter) throws RequestProcessingException;

    /**
     * Получить оффис по идентификатору
     */
    OfficeView getOfficeById(Long id);

}
