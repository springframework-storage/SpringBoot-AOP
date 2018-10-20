package com.springboot.aop.second;

import com.springboot.aop.cases.second.board.BoardServiceSecondStep;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceSecondStepTest {

  @Autowired
  private BoardServiceSecondStep boardServiceSecondStep;

  @Test
  public void findBoards() throws Exception {
    Assert.assertEquals(boardServiceSecondStep.getBoards().size(), 100);
  }

}
