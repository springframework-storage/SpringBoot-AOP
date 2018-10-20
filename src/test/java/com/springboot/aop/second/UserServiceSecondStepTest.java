package com.springboot.aop.second;

import com.springboot.aop.cases.second.user.UserServiceSecondStep;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceSecondStepTest {

  @Autowired
  private UserServiceSecondStep userServiceSecondStep;

  @Test
  public void findUsers() throws Exception {
    Assert.assertEquals(userServiceSecondStep.getUsers().size(), 100);
  }

}
