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
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final OrganizationDao organizationDao;

    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OrganizationListView> list(OrganizationFilter organizationFilter) throws RequestProcessingException {

        List<Organization> organizations = organizationDao.list(organizationFilter);
        return transformEntityToView(organizations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOrg(OrganizationUpdateView organizationUpdateView) {
        Organization organization = new Organization(organizationUpdateView.name,
                organizationUpdateView.fullName,
                organizationUpdateView.inn,
                organizationUpdateView.kpp,
                organizationUpdateView.address,
                organizationUpdateView.phone,
                organizationUpdateView.isActive);
        organization.setId(organizationUpdateView.id);
        organizationDao.save(organization);
        log.info("Organization add as " + organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteOrg(Long id) {
        organizationDao.deleteById(id);
    }

    private List<OrganizationListView> transformEntityToView(List<Organization> organizations) {
        Function<Organization, OrganizationListView> mapOrganization = o -> {
            OrganizationListView organizationListView = new OrganizationListView();
            organizationListView.id = o.getId();
            organizationListView.name = o.getName();
            organizationListView.isActive = o.getActive();

            log.info(organizationListView.toString());

            return organizationListView;
        };
        return organizations.stream().map(mapOrganization).collect(Collectors.toList());
    }

    @Override
    public OrganizationUpdateView getOrgById(Long id) {
        Organization organization = organizationDao.getById(id);
        return new OrganizationUpdateView(organization.getId(),
                organization.getName(),
                organization.getFullName(),
                organization.getInn(),
                organization.getKpp(),
                organization.getAddress(),
                organization.getPhone(),
                organization.getActive());
    }

    @Override
    public void save(OrganizationSaveView view) {
        Organization organization = new Organization(view.name,
                view.fullName,
                view.inn,
                view.kpp,
                view.address,
                view.phone,
                view.isActive);
        organizationDao.save(organization);
        log.info("Organization add as " + organization);

    }
}
