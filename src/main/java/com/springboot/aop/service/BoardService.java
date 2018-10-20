package com.springboot.aop.service;

import com.springboot.aop.domain.Board;
import com.springboot.aop.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<Board> getBoards() {
    long start = System.currentTimeMillis();
    List<Board> boards = boardRepository.findAll();
    long end = System.currentTimeMillis();

    log.info("*** 수행 시간: {}", end - start);
    return boards;
  }

}
