package ru.bellintegrator.practice.dictionary.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.dictionary.model.Country;

public interface CountryDao extends JpaRepository<Country, Long> {

    /**
     * Получить страну по коду
     */
    Country getCountryByCode(String code);

    /**
     * Получинать страну по названию
     */
    Country getCountryByName(String name);
}
