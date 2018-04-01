package ru.bellintegrator.practice.employee.dao.impl;

import com.google.common.base.Strings;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.employee.dao.EmployeeDao;
import ru.bellintegrator.practice.employee.model.Employee;
import ru.bellintegrator.practice.employee.view.EmployeeFilter;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager em;

    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Employee getById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        em.persist(employee);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

    @Override
    public List<Employee> list(EmployeeFilter employeeFilter) {

        Office office = em.find(Office.class, employeeFilter.officeId);
        String firstName = employeeFilter.firstName;
        String lastName = employeeFilter.lastName;
        String middleName = employeeFilter.middleName;
        String position = employeeFilter.position;
        String docCode = employeeFilter.docCode;
        String citizenshipCode = employeeFilter.citizenshipCode;

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.select(employeeRoot);

        Predicate criteria = criteriaBuilder.conjunction();

        if (!Strings.isNullOrEmpty(employeeFilter.officeId)) {
            Predicate predicate = criteriaBuilder.equal(employeeRoot.get("office"), office);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(firstName)) {
            Predicate predicate = criteriaBuilder.equal(employeeRoot.get("firstName"), firstName);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(lastName)) {
            Predicate predicate = criteriaBuilder.equal(employeeRoot.get("lastName"), lastName);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(middleName)) {
            Predicate predicate = criteriaBuilder.equal(employeeRoot.get("middleName"), middleName);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(position)) {
            Predicate predicate = criteriaBuilder.equal(employeeRoot.get("position"), position);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(docCode)) {
            Predicate predicate = criteriaBuilder.equal(employeeRoot.get("document"), docCode);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(citizenshipCode)) {
            Predicate predicate = criteriaBuilder.equal(employeeRoot.get("country"), citizenshipCode);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        criteriaQuery.where(criteria);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
