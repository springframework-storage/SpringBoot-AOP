package com.springboot.aop.service;

import com.springboot.aop.domain.User;
import com.springboot.aop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getUsers() {
    long start = System.currentTimeMillis();
    List<User> users = userRepository.findAll();
    long end = System.currentTimeMillis();

    log.info("*** 수행 시간: {}", end - start);
    return users;
  }

}
