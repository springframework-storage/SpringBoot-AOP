package com.springboot.aop.service.impl;

import com.springboot.aop.domain.Board;
import com.springboot.aop.repository.BoardRepository;
import com.springboot.aop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<Board> getBoards() {
    List<Board> boards = boardRepository.findAll();
    return boards;
  }

}
