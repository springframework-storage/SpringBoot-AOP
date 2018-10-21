package com.springboot.aop.aop;

import com.springboot.aop.domain.History;
import com.springboot.aop.domain.User;
import com.springboot.aop.repository.HistoryRepository;
import com.springboot.aop.service.BoardService;
import com.springboot.aop.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

  @Autowired
  private BoardService boardService;
  @Autowired
  private UserService userService;
  @Autowired
  private HistoryRepository historyRepository;

  @Test
  public void findBoards() throws Exception {
    Assert.assertEquals(boardService.getBoards().size(), 100);
  }

  @Test
  public void findUsers() throws Exception {
    Assert.assertEquals(userService.getUsers().size(), 100);
  }

  @Test
  public void updateUsers() throws Exception {
    List<User> users = userService.getUsers();
    for (int i = 0; i < 5; ++i) {
      User user = users.get(i);
      user.setEmail("mingooddev@gitflow.org");
      userService.update(user);
    }

    List<History> histories = historyRepository.findAll();
    Assert.assertEquals(histories.size(), 5);
  }

}
