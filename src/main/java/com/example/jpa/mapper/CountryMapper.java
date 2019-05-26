package com.example.jpa.mapper;

import com.example.jpa.model.dto.CountryDTO;
import com.example.jpa.model.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
  @Mapping(target = "states", ignore = true)
  CountryEntity dtoToEntity(CountryDTO countryDTO, @MappingTarget CountryEntity countryEntity);

  CountryMapper MAPPER = Mappers.getMapper(CountryMapper.class);
}
