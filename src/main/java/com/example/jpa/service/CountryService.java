package com.example.jpa.service;

import com.example.jpa.model.dto.CountryDTO;
import com.example.jpa.model.entity.CountryEntity;
import java.util.List;

public interface CountryService {
  void createCountry(CountryDTO countryDTO);
  List<CountryEntity> findCountrys();
  void deleteAll();
}
