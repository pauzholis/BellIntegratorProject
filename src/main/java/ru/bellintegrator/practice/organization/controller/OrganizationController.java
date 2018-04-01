package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationFilter;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;
import ru.bellintegrator.practice.registration.service.ValidationService;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;
    private final ValidationService validationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService, ValidationService validationService) {
        this.organizationService = organizationService;
        this.validationService = validationService;
    }

    @RequestMapping("/{id}")
    public OrganizationUpdateView organization(@PathVariable("id") Long id) {
        return organizationService.getOrgById(id);
    }

    /**
     * Отображение списка организаций
     */
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationListView> list(
            @RequestBody
                    OrganizationFilter organizationFilter, BindingResult result) throws RequestProcessingException {
        validationService.validate(result);
        return organizationService.list(organizationFilter);
    }

    /**
     * Обновление организации
     */
    @RequestMapping(value = "/update", method = {POST})
    public void update(
            @RequestBody
                    OrganizationUpdateView updateData, BindingResult result) throws RequestProcessingException {
        validationService.validate(result);
        organizationService.updateOrg(updateData);
    }

    /**
     * Сохранение огранизации
     */
    @RequestMapping(value = "/save", method = {POST})
    public void save(
            @RequestBody
                    OrganizationSaveView saveData, BindingResult result) throws RequestProcessingException {
        validationService.validate(result);
        organizationService.save(saveData);
    }

    /**
     * Удаление огранизации
     */
    @RequestMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        organizationService.deleteOrg(id);
    }
}
