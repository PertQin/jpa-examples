package com.example.jpa.model.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(columnDefinition = "Long", updatable = false, nullable = false)
  private Long id;

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
