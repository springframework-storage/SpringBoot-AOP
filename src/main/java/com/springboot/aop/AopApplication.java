package com.springboot.aop;

import com.springboot.aop.domain.Board;
import com.springboot.aop.domain.User;
import com.springboot.aop.repository.BoardRepository;
import com.springboot.aop.repository.UserRepository;
import com.springboot.aop.service.BoardService;
import com.springboot.aop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.tools.jar.CommandLine;

import java.util.List;

@Slf4j
@SpringBootApplication
@RestController
public class AopApplication implements CommandLineRunner {

  @Autowired
  private BoardService boardService;
  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private UserService userService;
  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    for (int i = 1; i <= 100; ++i) {
      boardRepository.save(new Board(i + "번째 게시글의 제목", i + "번째 게시글의 내용"));
      userRepository.save(new User(i + "@gitflow.org", i + "번째 사용자"));
    }
  }

  @GetMapping("/boards")
  public List<Board> boardList() {
    return boardService.getBoards();
  }

  @GetMapping("/users")
  public List<User> userList() {
    return userService.getUsers();
  }

  public static void main(String[] args) {
    SpringApplication.run(AopApplication.class, args);
  }

}
