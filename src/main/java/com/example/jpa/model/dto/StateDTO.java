package com.example.jpa.model.dto;

import com.example.jpa.model.entity.CountryEntity;
import com.example.jpa.model.entity.RegionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateDTO {

  private String id;

  private String name;

  private String shortName;

  private CountryEntity country;

  private RegionEntity region;

  private String createdBy;

  private String updatedBy;
}
