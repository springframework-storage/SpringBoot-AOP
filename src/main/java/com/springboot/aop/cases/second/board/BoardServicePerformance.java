package com.springboot.aop.cases.second.board;

import com.springboot.aop.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Primary
public class BoardServicePerformance implements BoardServiceSecondStep {

  @Autowired
  @Qualifier("boardServiceImplSecondStep")
  private BoardServiceSecondStep boardServiceSecondStep;

  @Override
  public List<Board> getBoards() {
    long start = before();
    List<Board> boards = boardServiceSecondStep.getBoards();
    after(start);

    return boards;
  }

  private long before() {
    return System.currentTimeMillis();
  }

  private void after(long start) {
    long end = System.currentTimeMillis();
    log.info("*** 수행 시간: {}", end - start);
  }
}
