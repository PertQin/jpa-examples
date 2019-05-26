package com.example.jpa.mapper;

import com.example.jpa.model.dto.RegionDTO;
import com.example.jpa.model.entity.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper {

  RegionEntity dtoToRegionDTO(RegionDTO regionDTO, @MappingTarget RegionEntity regionEntity);

  RegionMapper MAPPER = Mappers.getMapper(RegionMapper.class);
}
