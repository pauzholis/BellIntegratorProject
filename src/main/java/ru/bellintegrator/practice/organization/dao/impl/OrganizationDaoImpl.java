package ru.bellintegrator.practice.organization.dao.impl;

import com.google.common.base.Strings;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationFilter;

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
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Organization getById(Long id) {

        return em.find(Organization.class, id);
    }

    @Override
    public void save(Organization org) {
        em.persist(org);
    }

    @Override
    public void deleteById(Long id) {
        Organization org = em.find(Organization.class, id);
        em.remove(org);
    }

    @Override
    public List<Organization> list(OrganizationFilter organizationFilter) {

        String name = organizationFilter.name;
        String inn = organizationFilter.inn;
        Boolean isActive = organizationFilter.isActive;

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);

        criteriaQuery.select(organizationRoot);

        Predicate criteria = criteriaBuilder.conjunction();

        if (!Strings.isNullOrEmpty(name)) {
            Predicate predicate = criteriaBuilder.equal(organizationRoot.get("name"), name);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (!Strings.isNullOrEmpty(inn)) {
            Predicate predicate = criteriaBuilder.equal(organizationRoot.get("inn"), inn);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if (isActive != null) {
            Predicate predicate = criteriaBuilder.equal(organizationRoot.get("isActive"), isActive);
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        criteriaQuery.where(criteria);
        List<Organization> organizations = em.createQuery(criteriaQuery).getResultList();

        return organizations;
    }
}
