package com.springboot.aop.firstStep.controller;

import com.springboot.aop.domain.Board;
import com.springboot.aop.domain.User;
import com.springboot.aop.firstStep.service.BoardServiceFirstStep;
import com.springboot.aop.firstStep.service.UserServiceFirstStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("firstStep")
public class FirstStepController {

  @Autowired
  private BoardServiceFirstStep boardServiceFirstStep;
  @Autowired
  private UserServiceFirstStep userServiceFirstStep;

  @GetMapping("boards")
  public List<Board> getBoards() {
    return boardServiceFirstStep.getDataAll();
  }

  @GetMapping("users")
  public List<User> getUsers() {
    return userServiceFirstStep.getDataAll();
  }

}
