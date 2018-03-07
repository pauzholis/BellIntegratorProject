package ru.bellintegrator.practice.organization.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.view.OrganizationListRequestView;
import ru.bellintegrator.practice.organization.view.OrganizationListResultView;
import ru.bellintegrator.practice.organization.view.OrganizationResultView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateRequestView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateResultView;
import ru.bellintegrator.practice.registration.view.LoginRequestView;
import ru.bellintegrator.practice.registration.view.LoginResultView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    @RequestMapping("/{id}")
    public OrganizationResultView organization (){
        OrganizationResultView response = new OrganizationResultView();
        response.isActive = true;
        return response;
    }

    /**
     * Ответ на запрос по списку организаций
     */
    @RequestMapping(value = "/list", method = {POST})
    public OrganizationListResultView list(
            @RequestBody
                    OrganizationListRequestView organizationListRequestView) {
        OrganizationListResultView response = new OrganizationListResultView();
        response.isActive = true;
        return response;
    }

    /**
     * Входные данные запроса на обновление организации
     */
    @RequestMapping(value = "/update", method = {POST})
    public OrganizationUpdateResultView update(
            @RequestBody
                    OrganizationUpdateRequestView updateData) {
        OrganizationUpdateResultView response = new OrganizationUpdateResultView();
        response.result = "success";
        return response;
    }
}
