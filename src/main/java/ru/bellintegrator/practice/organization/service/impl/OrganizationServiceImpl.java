package ru.bellintegrator.practice.organization.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationFilter;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final OrganizationDao organizationDao;

    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OrganizationView> list(OrganizationFilter organizationFilter) throws RequestProcessingException {

        checkFilterParams(organizationFilter);

        Organization organization = new Organization();

        organization.setName(organizationFilter.name);
        organization.setInn(organizationFilter.inn);
        organization.setActive(organizationFilter.isActive);

        List<Organization> organizations = organizationDao.list(organization);
        Function<Organization, OrganizationView> mapOrganization = o -> {
            OrganizationView organizationView = new OrganizationView();
            organizationView.id = o.getId();
            organizationView.name = o.getName();
            organizationView.isActive = o.getActive();

            LOG.info(organizationView.toString());

            return organizationView;
        };

        return organizations.stream().map(mapOrganization).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOrg(OrganizationView organizationView) {
        Organization organization = new Organization(organizationView.name,
                organizationView.fullName,
                organizationView.inn,
                organizationView.kpp,
                organizationView.address,
                organizationView.phone,
                organizationView.isActive);
        Organization result = organizationDao.save(organization);
        LOG.info("Organization add as " + organization);
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
    public void deleteOrg(Map<String, Long> id) {

    }

    private void checkFilterParams(OrganizationFilter organizationFilter) throws RequestProcessingException {
        if (organizationFilter.name == null) {
            throw new RequestProcessingException("Organization name is null");
        }
        if (organizationFilter.inn == null) {
            throw new RequestProcessingException("Organization inn is null");
        }
    }
}
