package com.springboot.aop.service;

import com.springboot.aop.domain.Board;
import com.springboot.aop.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<Board> getBoards() {
    return boardRepository.findAll();
  }

}
