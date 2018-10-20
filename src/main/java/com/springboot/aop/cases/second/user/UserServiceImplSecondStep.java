package com.springboot.aop.cases.second.user;

import com.springboot.aop.domain.User;
import com.springboot.aop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplSecondStep implements UserServiceSecondStep {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

}
