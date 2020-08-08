package com.example.demo.jpa;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractModel {
  @Column(nullable = false)
  @CreatedDate
  private LocalTime createdDate;

  @Column(nullable = false)
  @LastModifiedDate
  private LocalTime lastModifiedDate;

}
