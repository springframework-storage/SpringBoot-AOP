package com.springboot.aop.firstStep;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class SuperPerformance<T> {

  private long before() {
    return System.currentTimeMillis();
  }

  private void after(long start) {
    long end = System.currentTimeMillis();
    log.info("*** 수행 시간: {}", end - start);
  }

  public List<T> getDataAll() {
    long start = before();
    List<T> datas = findAll();
    after(start);

    return datas;
  }

  public abstract List<T> findAll();

}
