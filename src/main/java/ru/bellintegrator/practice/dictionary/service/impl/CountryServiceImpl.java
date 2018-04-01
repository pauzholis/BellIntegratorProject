package ru.bellintegrator.practice.dictionary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dictionary.dao.CountryDao;
import ru.bellintegrator.practice.dictionary.model.Country;
import ru.bellintegrator.practice.dictionary.service.CountryService;
import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public List<CountryView> getAllCounty() {
        List<Country> countries = countryDao.findAll();
        Function<Country, CountryView> mapCountry = c -> {
            CountryView countryView = new CountryView();
            countryView.name = c.getName();
            countryView.code = c.getCode();
            return countryView;
        };
        return countries.stream().map(mapCountry).collect(Collectors.toList());
    }
}