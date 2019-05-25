package com.example.jpa.service.impl;

import com.example.jpa.dao.CountryRepository;
import com.example.jpa.model.dto.CountryDTO;
import com.example.jpa.model.dto.StateDTO;
import com.example.jpa.service.CountryService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CountryServiceImpl implements CountryService {

  @Autowired
  private CountryRepository countryRepository;

  public void createCountry(CountryDTO countryDTO) {
    if (Objects.isNull(countryDTO)) {
      List<StateDTO> states = countryDTO.getStates();
      if (!CollectionUtils.isEmpty(states)) {
        states = states.stream()
            .filter(stateDTO -> Objects.isNull(stateDTO))
            .collect(Collectors.toList());
      }
    }
  }
}
