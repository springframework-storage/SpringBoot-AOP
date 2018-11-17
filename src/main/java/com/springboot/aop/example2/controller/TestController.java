package com.springboot.aop.example2.controller;

import com.springboot.aop.example2.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private TestService testService;

  public TestController(TestService testService) {
    this.testService = testService;
  }

  @GetMapping("noAop")
  public String noAop() {
    return testService.test();
  }

  @GetMapping("aop")
  public String aop() {
    return testService.testAop();
  }

}
