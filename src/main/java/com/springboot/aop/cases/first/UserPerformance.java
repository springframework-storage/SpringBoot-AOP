package com.springboot.aop.cases.first;

import com.springboot.aop.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class UserPerformance {

  private long before() {
    return System.currentTimeMillis();
  }

  private void after(long start) {
    long end = System.currentTimeMillis();
    log.info("*** 수행 시간: {}", end - start);
  }

  public List<User> getUsers() {
    long start = before();
    List<User> users = findAll();
    after(start);

    return users;
  }

  public abstract List<User> findAll();

}
