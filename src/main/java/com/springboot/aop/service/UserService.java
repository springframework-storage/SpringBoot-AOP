package com.springboot.aop.service;

import com.springboot.aop.domain.User;

import java.util.List;

public interface UserService {

  List<User> getUsers();

  void update(User user) throws Exception;

}
