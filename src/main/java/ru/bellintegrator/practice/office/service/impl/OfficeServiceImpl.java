package ru.bellintegrator.practice.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeListView;
import ru.bellintegrator.practice.office.view.OfficeSaveView;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.response.RequestProcessingException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteOffice(Long id) {
        officeDao.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOffice(OfficeView officeView) {
        Office office = officeDao.getById(officeView.id);
        office.setName(officeView.name);
        office.setAddress(officeView.address);
        office.setPhone(officeView.phone);
        office.setActive(officeView.isActive);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OfficeListView> list(OfficeFilter officeFilter) throws RequestProcessingException {

        List<Office> offices = officeDao.list(officeFilter);
        return transformEntityToView(offices);
    }

    private List<OfficeListView> transformEntityToView(List<Office> offices) {
        Function<Office, OfficeListView> mapOffice = o -> {
            OfficeListView officeListView = new OfficeListView();
            officeListView.id = o.getId();
            officeListView.name = o.getName();
            officeListView.isActive = o.getActive();

            log.info(officeListView.toString());

            return officeListView;
        };
        return offices.stream().map(mapOffice).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOffice(OfficeSaveView officeSaveView) {
        Office office = new Office();
        office.setName(officeSaveView.name);
        office.setAddress(officeSaveView.address);
        office.setPhone(officeSaveView.phone);
        office.setActive(officeSaveView.isActive);
        officeDao.save(office);
        log.info("Office add as " + office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OfficeView getOfficeById(Long id) {
        Office office = officeDao.getById(id);
        OfficeView officeView = new OfficeView();
        officeView.id = office.getId();
        officeView.name = office.getName();
        officeView.address = office.getAddress();
        officeView.phone = office.getPhone();
        officeView.isActive = office.getActive();
        return officeView;
    }
}
