package ru.bellintegrator.practice.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.employee.service.EmployeeService;
import ru.bellintegrator.practice.employee.view.EmployeeFilter;
import ru.bellintegrator.practice.employee.view.EmployeeListResponseView;
import ru.bellintegrator.practice.registration.service.ValidationService;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ValidationService validationService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ValidationService validationService) {
        this.employeeService = employeeService;
        this.validationService = validationService;
    }

    /**
     * Отображение списка организаций
     */
    @RequestMapping(value = "/list", method = {POST})
    public List<EmployeeListResponseView> list(
            @RequestBody
                    EmployeeFilter employeeFilter, BindingResult result) throws RequestProcessingException {
        validationService.validate(result);
        return employeeService.list(employeeFilter);
    }
}
