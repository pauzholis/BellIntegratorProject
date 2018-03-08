package ru.bellintegrator.practice.office.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.view.OfficeDeleteRequestView;
import ru.bellintegrator.practice.office.view.OfficeDeleteResultView;
import ru.bellintegrator.practice.office.view.OfficeListRequestView;
import ru.bellintegrator.practice.office.view.OfficeListResultView;
import ru.bellintegrator.practice.office.view.OfficeResultView;
import ru.bellintegrator.practice.office.view.OfficeUpdateRequestView;
import ru.bellintegrator.practice.office.view.OfficeUpdateResultView;
import ru.bellintegrator.practice.organization.view.OrganizationSaveRequestView;
import ru.bellintegrator.practice.organization.view.OrganizationSaveResultView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    @RequestMapping("/list/{orgId}")
    public OfficeListResultView list(
            @RequestBody
                    OfficeListRequestView officeListData) {
        OfficeListResultView response = new OfficeListResultView();
        response.isActive = true;
        return response;
    }

    @RequestMapping("/{id}")
    public OfficeResultView office() {
        OfficeResultView response = new OfficeResultView();
        response.isActive = true;
        return response;
    }

    /**
     * Обновление данных оффиса
     */
    @RequestMapping(value = "/update", method = {POST})
    public OfficeUpdateResultView update(
            @RequestBody
                    OfficeUpdateRequestView updateData) {
        OfficeUpdateResultView response = new OfficeUpdateResultView();
        response.result = "success";
        return response;
    }

    /**
     * Удаление оффиса
     */
    @RequestMapping(value = "/delete", method = {POST})
    public OfficeDeleteResultView update(
            @RequestBody
                    OfficeDeleteRequestView deleteData) {
        OfficeDeleteResultView response = new OfficeDeleteResultView();
        response.result = "success";
        return response;
    }

    /**
     * Сохраниение оффиса
     */
    @RequestMapping(value = "/save", method = {POST})
    public OrganizationSaveResultView update(
            @RequestBody
                    OrganizationSaveRequestView saveData) {
        OrganizationSaveResultView response = new OrganizationSaveResultView();
        response.result = "success";
        return response;
    }
}
