package ru.bellintegrator.practice.dictionary.service;


import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.List;

public interface CountryService {

    /**
     * Получить перечень стран
     */
    List<CountryView> getAllCounty();
}
