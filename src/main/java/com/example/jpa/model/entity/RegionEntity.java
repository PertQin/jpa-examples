package com.example.jpa.model.entity;

import javax.persistence.Entity;
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
@Table(name = "region")
@Accessors(chain = true)
public class RegionEntity extends BaseEntity {
  private String name;

  private String shortName;

  private String regionCode;
}
