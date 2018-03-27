package ru.bellintegrator.practice.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.Map;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteOffice(Map<String, Long> id) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String saveOffice(OrganizationView orgView) {
        return null;
    }
}
