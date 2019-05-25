package com.example.jpa.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "state")
@Accessors(chain = true)
public class StateEntity extends BaseEntity {

  private String name;

  private String shortName;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "country_id")
  private CountryEntity country;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "region_id")
  private RegionEntity region;
}
