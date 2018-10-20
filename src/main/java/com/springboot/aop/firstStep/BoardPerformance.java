package com.springboot.aop.firstStep;

import com.springboot.aop.domain.Board;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class BoardPerformance {

  private long before() {
    return System.currentTimeMillis();
  }

  private void after(long start) {
    long end = System.currentTimeMillis();
    log.info("*** 수행 시간: {}", end - start);
  }

  public List<Board> getBoards() {
    long start = before();
    List<Board> boards = findAll();
    after(start);

    return boards;
  }

  public abstract List<Board> findAll();

}
