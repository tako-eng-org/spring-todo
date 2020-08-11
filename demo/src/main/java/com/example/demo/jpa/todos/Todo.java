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
@Getter // lombokによる
@Setter // lombokによる
public class Todo extends AbstractModel {
  @Id
  @GeneratedValue
  private Integer id; // 主キー(自動採番)

  @Column(nullable = false)
  private String body; // TODOリストの本文

  // AbstractModelの2つもここに入っているイメージ

  // // setter,getterはlombokにより生成しているので不要。
  // public void setBody(String body) {
  // this.body = body;
  // }
}