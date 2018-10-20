package com.springboot.aop.cases.second.board;

import com.springboot.aop.domain.Board;
import com.springboot.aop.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImplSecondStep implements BoardServiceSecondStep {

  @Autowired
  private BoardRepository boardRepository;

  @Override
  public List<Board> getBoards() {
    return boardRepository.findAll();
  }

}
