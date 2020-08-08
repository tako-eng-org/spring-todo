package com.example.demo.jpa.todos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.example.demo.jpa.AbstractModel;

@Entity
@Table(name = "todos")
@Getter
@Setter
public class Todo extends AbstractModel {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable = false)
  private String body;

  // public void setBody(String body) {
  // this.body = body;
  // }

  // AbstractModelの2つもここに入っているイメージ
}