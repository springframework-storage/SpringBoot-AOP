package com.springboot.aop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class History {

  @Id
  @GeneratedValue
  private long idx;

  @Column
  private long userIdx;

  @Column
  private Date updateDate;

  public History() {}

  public History(long userIdx) {
    this.userIdx = userIdx;
  }

  public History(long userIdx, Date updateDate) {
    this.userIdx =  userIdx;
    this.updateDate = updateDate;
  }

}
