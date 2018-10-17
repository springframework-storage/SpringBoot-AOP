package com.springboot.aop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class User {

  @Id
  @GeneratedValue
  private long idx;

  @Column
  private String email;
  @Column
  private String name;

  public User() {}

  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }

}
