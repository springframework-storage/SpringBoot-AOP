package com.springboot.aop.firstStep.service;

import com.springboot.aop.domain.Board;
import com.springboot.aop.firstStep.SuperPerformance;
import com.springboot.aop.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceFirstStep extends SuperPerformance<Board> {

  @Autowired
  private BoardRepository boardRepository;

  @Override
  public List<Board> findAll() {
    return boardRepository.findAll();
  }

}
