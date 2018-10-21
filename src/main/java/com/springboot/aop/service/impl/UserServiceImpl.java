package com.springboot.aop.service.impl;

import com.springboot.aop.domain.User;
import com.springboot.aop.repository.UserRepository;
import com.springboot.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getUsers() {
    List<User> users = userRepository.findAll();
    return users;
  }

  @Override
  public void update(User user) throws Exception {
    userRepository.save(user);
  }

}
