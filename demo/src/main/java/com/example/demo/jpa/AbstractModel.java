package com.example.demo.jpa;

import java.time.LocalTime;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Table;
import java.sql.Timestamp;

// 日時情報など、1テーブルごとに必要になるような情報
@EntityListeners(AuditingEntityListener.class)
// @Table(name = "todos") // 不要かも。
@Getter // lombokによる
@Setter // lombokによる
public abstract class AbstractModel {
  // @CreatedDate
  // @CreationTimestamp
  // @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = true)
  private Timestamp createdDate;

  // @LastModifiedDate
  @Column(nullable = true)
  private Timestamp lastModifiedDate;

  // @PreUpdate
  // public void onPreUpdate() {
  // setUpdatedDate(new Date());
  // }
}
