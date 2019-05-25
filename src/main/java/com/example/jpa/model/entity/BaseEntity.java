package com.example.jpa.model.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "String", updatable = false, nullable = false)
  private String id;

  protected Date createdDate;

  protected Date updatedDate;

  protected String createdBy;

  protected String updatedBy;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseEntity that = (BaseEntity) o;
    return Objects.equals(id, that.id)
        && Objects.equals(createdDate, that.createdDate)
        && Objects.equals(updatedDate, that.updatedDate)
        && Objects.equals(createdBy, that.createdBy)
        && Objects.equals(updatedBy, that.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdDate, updatedDate, createdBy, updatedBy);
  }
}
