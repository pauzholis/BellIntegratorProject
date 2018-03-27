package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationFilter;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping("/{id}")
    public OrganizationView organization(@PathVariable("id") Long id) {
        OrganizationView response = new OrganizationView();
        response.isActive = true;
        return response;
    }

    /**
     * Отображение списка организаций
     */
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationView> list(
            @RequestBody
                    OrganizationFilter organizationFilter) throws RequestProcessingException {
        return organizationService.list(organizationFilter);
    }

    /**
     * Обновление организации
     */
    @RequestMapping(value = "/update", method = {POST})
    public void update(
            @RequestBody
                    OrganizationView updateData) {
        organizationService.updateOrg(updateData);
    }

    /**
     * Сохранение огранизации
     */
    @RequestMapping(value = "/save", method = {POST})
    public void save(
            @RequestBody
                    OrganizationView saveData) {
        organizationService.saveOrg(saveData);
    }

    /**
     * Удаление огранизации
     */
    @RequestMapping(value = "/delete", method = {POST})
    public void delete(
            @RequestBody
                    Map<String, Long> id) {
        organizationService.deleteOrg(id);
    }
}
