package ru.bellintegrator.practice.office.dao.impl;

import com.google.common.base.Strings;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.organization.model.Organization;

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
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void deleteById(Long id) {
        Office office = em.find(Office.class, id);
        em.remove(office);
    }

    @Override
    public List<Office> list(OfficeFilter officeFilter) {

        Organization organization = em.find(Organization.class, officeFilter.orgId);
        String name = officeFilter.name;
        String phone = officeFilter.phone;
        Boolean isActive = officeFilter.isActive;

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> officeRoot = criteriaQuery.from(Office.class);

        criteriaQuery.select(officeRoot);

        Predicate criteria = criteriaBuilder.conjunction();

        if (!Strings.isNullOrEmpty(officeFilter.orgId)) {
            Predicate predicate = criteriaBuilder.equal(officeRoot.get("organization"), organization);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(name)) {
            Predicate predicate = criteriaBuilder.equal(officeRoot.get("name"), name);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(phone)) {
            Predicate predicate = criteriaBuilder.equal(officeRoot.get("phone"), phone);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (isActive != null) {
            Predicate predicate = criteriaBuilder.equal(officeRoot.get("isActive"), isActive);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        criteriaQuery.where(criteria);
        List<Office> offices = em.createQuery(criteriaQuery).getResultList();

        return offices;
    }

    @Override
    public Office getById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }
}
