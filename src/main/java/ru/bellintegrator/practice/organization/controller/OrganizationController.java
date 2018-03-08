package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationDeleteRequestView;
import ru.bellintegrator.practice.organization.view.OrganizationDeleteResultView;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationSaveRequestView;
import ru.bellintegrator.practice.organization.view.OrganizationSaveResultView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

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
    public List<OrganizationListView> list(
            @RequestBody
                    OrganizationListView organizationListView) {
        return organizationService.list(organizationListView.name, organizationListView.isActive);
    }

    /**
     * Обновление организации
     */
    @RequestMapping(value = "/update", method = {POST})
    public OrganizationView update(
            @RequestBody
                    OrganizationView updateData) {
        updateData.result = "success";
        return updateData;
    }

    /**
     * Сохранение огранизации
     */
    @RequestMapping(value = "/save", method = {POST})
    public OrganizationSaveResultView update(
            @RequestBody
                    OrganizationSaveRequestView saveData) {
        OrganizationSaveResultView response = new OrganizationSaveResultView();
        response.result = "success";
        return response;
    }

    /**
     * Удаление огранизации
     */
    @RequestMapping(value = "/delete", method = {POST})
    public OrganizationDeleteResultView update(
            @RequestBody
                    OrganizationDeleteRequestView deleteData) {
        OrganizationDeleteResultView response = new OrganizationDeleteResultView();
        response.result = "success";
        return response;
    }
}
