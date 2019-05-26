package com.example.jpa.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "country_id")
  private CountryEntity country;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "region_id")
  private RegionEntity region;
}
