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
public class Board {

  @Id
  @GeneratedValue
  private Long idx;

  @Column
  private String title;
  @Column
  private String content;

  public Board() {}

  public Board(String title, String content) {
    this.title = title;
    this.content = content;
  }

}
