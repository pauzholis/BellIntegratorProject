package ru.bellintegrator.practice.organization.service.impl;

import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * {@inheritDoc}
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger logger = getLogger(OrganizationServiceImpl.class);
    private final OrganizationDao organizationDao;

    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationListView> list(String name, boolean isActive) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public String updateOrg(OrganizationView organizationView) {
        Organization organization = new Organization(organizationView.name,
                organizationView.fullName,
                organizationView.inn,
                organizationView.kpp,
                organizationView.address,
                organizationView.phone,
                organizationView.isActive);
        Organization result = organizationDao.save(organization);
        logger.info("Organization add as " + organization);
        return (result.getId() > 0) ? "{\"result\":\"success\"}" : "{\"error\":\"\"}";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String saveOrg(OrganizationView orgView) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteOrg(Map<String, Long> id) {
        return (organizationDao.deleteOrgById(id.get("id"))) ? "{\"result\":\"success\"}" : "{\"error\":\"\"}";
    }
}
