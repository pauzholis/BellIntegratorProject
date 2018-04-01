package ru.bellintegrator.practice.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeListView;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.registration.service.ValidationService;
import ru.bellintegrator.practice.response.RequestProcessingException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;
    private final ValidationService validationService;

    @Autowired
    public OfficeController(OfficeService officeService, ValidationService validationService) {
        this.officeService = officeService;
        this.validationService = validationService;
    }

    @RequestMapping("/list")
    public List<OfficeListView> list(
            @RequestBody
                    OfficeFilter filter, BindingResult result) throws RequestProcessingException {
        validationService.validate(result);
        return officeService.list(filter);
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
    public void update(@Valid @RequestBody OfficeView updateData, BindingResult result)
            throws RequestProcessingException {
        validationService.validate(result);
        officeService.updateOffice(updateData);
    }

    /**
     * Удаление оффиса
     */
    @RequestMapping(value = "/delete", method = {POST})
    public void deleteOffice(
            @RequestBody
                    Long id) {
        officeService.deleteOffice(id);
    }
}
