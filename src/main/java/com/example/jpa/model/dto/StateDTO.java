package com.example.jpa.model.dto;

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

  private Long id;

  private String name;

  private String shortName;

  private RegionDTO region;

  private String createdBy;

  private String updatedBy;
}
