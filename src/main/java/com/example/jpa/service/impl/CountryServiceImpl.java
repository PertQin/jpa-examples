package com.example.jpa.service.impl;

import com.example.jpa.dao.CountryRepository;
import com.example.jpa.dao.RegionRepository;
import com.example.jpa.dao.StateRepository;
import com.example.jpa.mapper.CountryMapper;
import com.example.jpa.mapper.RegionMapper;
import com.example.jpa.model.dto.CountryDTO;
import com.example.jpa.model.dto.RegionDTO;
import com.example.jpa.model.dto.StateDTO;
import com.example.jpa.model.entity.CountryEntity;
import com.example.jpa.model.entity.RegionEntity;
import com.example.jpa.model.entity.StateEntity;
import com.example.jpa.service.CountryService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

  @Autowired
  private CountryRepository countryRepository;

  @Autowired
  private RegionRepository regionRepository;

  public void createCountry(CountryDTO countryDTO) {
    if (!Objects.isNull(countryDTO)) {
      List<StateDTO> states = countryDTO.getStates();
      if (!CollectionUtils.isEmpty(states)) {
        states = states.stream()
            .filter(stateDTO -> !Objects.isNull(stateDTO))
            .collect(Collectors.toList());

        CountryEntity countryEntity = CountryMapper.MAPPER.dtoToEntity(countryDTO, new CountryEntity());
        this.countryRepository.save(countryEntity);

        for (StateDTO stateDTO : states) {
          RegionEntity regionEntity = createOrUpdate(stateDTO.getRegion());
          countryEntity.getStates().add(new StateEntity()
              .setName(stateDTO.getName())
              .setShortName(stateDTO.getShortName())
              .setCountry(countryEntity)
              .setRegion(regionEntity));
        }
        this.countryRepository.save(countryEntity);
      }
    }
  }

  public RegionEntity createOrUpdate(RegionDTO regionDTO) {
    RegionEntity regionEntity = RegionMapper.MAPPER.dtoToRegionDTO(regionDTO, new RegionEntity());
    return this.regionRepository.save(regionEntity);
  }

  public List<CountryEntity> findCountrys() {
    return this.countryRepository.findAll();
  }

  public void deleteAll() {
    this.countryRepository.deleteAll();
  }
}
