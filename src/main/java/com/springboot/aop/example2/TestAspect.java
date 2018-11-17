package com.springboot.aop.example2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

  /**
   * 로그를 찍는 Aspect
   */

  private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

  @Before("execution(* com.springboot.aop.example2.service.*.*Aop(..))")
  public void onBeforeHandler(JoinPoint joinPoint) {
    logger.info("### onBeforeThing");
  }

  @After("execution(* com.springboot.aop.example2.service.*.*Aop(..))")
  public void onAfterHandler(JoinPoint joinPoint) {
    logger.info("### onAfterHandler");
  }

  @AfterReturning(pointcut = "execution(* com.springboot.aop.example2.service.*.*Aop(..))",
          returning = "str")
  public void onAfterReturningHandler(JoinPoint joinPoint, Object str) {
    logger.info("### @AfterReturning : {}", str);
    logger.info("### onAfterReturningHandler");
  }

  @Pointcut("execution(* com.springboot.aop.example2.service.*.*Aop(..))")
  public void onPointcut(JoinPoint joinPoint) {
    logger.info("### onPointcut");
  }

}
