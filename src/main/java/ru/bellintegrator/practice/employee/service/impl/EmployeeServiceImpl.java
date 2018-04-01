package ru.bellintegrator.practice.employee.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dictionary.dao.CountryDao;
import ru.bellintegrator.practice.dictionary.dao.DocumentTypeDao;
import ru.bellintegrator.practice.dictionary.model.Country;
import ru.bellintegrator.practice.dictionary.model.DocumentType;
import ru.bellintegrator.practice.employee.dao.EmployeeDao;
import ru.bellintegrator.practice.employee.model.Document;
import ru.bellintegrator.practice.employee.model.Employee;
import ru.bellintegrator.practice.employee.service.EmployeeService;
import ru.bellintegrator.practice.employee.view.EmployeeFilter;
import ru.bellintegrator.practice.employee.view.EmployeeListResponseView;
import ru.bellintegrator.practice.employee.view.EmployeeSaveView;
import ru.bellintegrator.practice.employee.view.EmployeeView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final EmployeeDao employeeDao;
    private final DocumentTypeDao documentTypeDao;
    private final CountryDao countryDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao, DocumentTypeDao documentTypeDao, CountryDao countryDao) {
        this.employeeDao = employeeDao;
        this.documentTypeDao = documentTypeDao;
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<EmployeeListResponseView> list(EmployeeFilter employeeFilter) throws RequestProcessingException {

        List<Employee> employees = employeeDao.list(employeeFilter);
        return transformEntityToView(employees);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateEmployee(EmployeeView employeeView) {
        Employee employee = employeeDao.getById(employeeView.id);
        DocumentType documentType = documentTypeDao.findByName(employeeView.docName);

        employee.setFirstName(employeeView.firstName);
        employee.setSecondName(employeeView.secondName);
        employee.setMiddleName(employeeView.middleName);
        employee.setDocument(new Document(documentType, employeeView.docNumber, employeeView.docDate));
        employee.setPhone(employeeView.phone);
        employee.setPosition(employeeView.position);
        employee.setCountry(new Country(employeeView.citizenshipName, employeeView.citizenshipCode));
        employee.setIdentified(true);
        employeeDao.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteEmployee(Long id) {
        employeeDao.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeView getEmployeeById(Long id) {
        Employee employee = employeeDao.getById(id);
        EmployeeView view = new EmployeeView();
        view.id = employee.getId();
        view.firstName = employee.getFirstName();
        view.secondName = employee.getSecondName();
        view.middleName = employee.getMiddleName();
        view.position = employee.getPosition();
        view.phone = employee.getPhone();
        view.docName = employee.getDocument().getDocumentType().getName();
        view.docNumber = employee.getDocument().getNumber();
        view.docDate = employee.getDocument().getDate();
        view.citizenshipName = employee.getCountry().getName();
        view.citizenshipCode = employee.getCountry().getCode();
        view.isIdentified = employee.getIdentified();
        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(EmployeeSaveView employeeSaveView) {
        Employee employee = new Employee();

        DocumentType documentType;
        if (employeeSaveView.docName != null) {
            documentType = documentTypeDao.findByName(employeeSaveView.docName);
        } else {
            documentType = documentTypeDao.findByCode(employeeSaveView.docCode);
        }
        Country country;
        if (employeeSaveView.citizenshipName != null) {
            country = countryDao.getCountryByName(employeeSaveView.citizenshipName);
        } else {
            country = countryDao.getCountryByCode(employeeSaveView.citizenshipCode);
        }

        employee.setFirstName(employeeSaveView.firstName);
        employee.setSecondName(employeeSaveView.secondName);
        employee.setMiddleName(employeeSaveView.middleName);
        employee.setPosition(employeeSaveView.position);
        employee.setPhone(employeeSaveView.phone);
        employee.setDocument(new Document(documentType, employeeSaveView.docNumber, employeeSaveView.docDate));
        employee.setCountry(country);
        employee.setIdentified(true);
        employeeDao.save(employee);
        log.info("Employee add as " + employee);
    }

    private List<EmployeeListResponseView> transformEntityToView(List<Employee> employees) {
        Function<Employee, EmployeeListResponseView> mapEmployee = e -> {
            EmployeeListResponseView employeeListResponseView = new EmployeeListResponseView();
            employeeListResponseView.id = e.getId();
            employeeListResponseView.firstName = e.getFirstName();
            employeeListResponseView.secondName = e.getSecondName();
            employeeListResponseView.middleName = e.getMiddleName();
            employeeListResponseView.position = e.getPosition();

            log.info(employeeListResponseView.toString());

            return employeeListResponseView;
        };
        return employees.stream().map(mapEmployee).collect(Collectors.toList());
    }
}
