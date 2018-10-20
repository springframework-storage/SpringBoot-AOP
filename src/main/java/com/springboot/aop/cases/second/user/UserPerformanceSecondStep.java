package com.springboot.aop.cases.second.user;

import com.springboot.aop.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Primary
public class UserPerformanceSecondStep implements UserServiceSecondStep {

  @Autowired
  @Qualifier("userServiceImplSecondStep")
  private UserServiceSecondStep userServiceSecondStep;

  @Override
  public List<User> getUsers() {
    long start = System.currentTimeMillis();
    List<User> users = userServiceSecondStep.getUsers();
    after(start);

    return users;
  }

  private long before() {
    return System.currentTimeMillis();
  }

  private void after(long start) {
    long end = System.currentTimeMillis();
    log.info("*** 수행 시간: {}", end - start);
  }

}
