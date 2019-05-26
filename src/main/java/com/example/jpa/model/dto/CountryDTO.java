package com.example.jpa.model.dto;

import java.util.List;
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
public class CountryDTO {

  private Long id;

  private String name;

  private String shortName;

  private String countryCode;

  private String createdBy;

  private String updatedBy;

  private List<StateDTO> states;
}
