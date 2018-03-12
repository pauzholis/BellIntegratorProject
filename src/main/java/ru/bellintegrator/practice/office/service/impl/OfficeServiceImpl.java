package ru.bellintegrator.practice.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.Map;

/**
 * {@inheritDoc}
 */

public class OfficeServiceImpl implements OfficeService{

    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteOffice(Map<String, Long> id) {
        return (officeDao.deleteOfficeById(id.get("id"))) ? "{\"result\":\"success\"}" : "{\"error\":\"\"}";
    }

    @Override
    public String saveOffice(OrganizationView orgView) {
        return null;
    }
}
