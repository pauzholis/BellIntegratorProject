package ru.bellintegrator.practice.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeListView;
import ru.bellintegrator.practice.office.view.OfficeUpdateRequestView;
import ru.bellintegrator.practice.office.view.OfficeUpdateResultView;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping("/list")
    public OfficeListView list(
            @RequestBody
                    OfficeFilter filter) {
        OfficeListView response = new OfficeListView();
        response.isActive = true;
        return response;
    }

    @RequestMapping("/{id}")
    public OfficeView office(@PathVariable("id") Long id) {
        OfficeView response = new OfficeView();
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
    public void deleteOffice(
            @RequestBody
                    Map<String, Long> id) {
        officeService.deleteOffice(id);
    }
}
