package com.springboot.aop.aspect;

import com.springboot.aop.domain.History;
import com.springboot.aop.domain.User;
import com.springboot.aop.repository.HistoryRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserHistory {

  @Autowired
  private HistoryRepository historyRepository;

  /**
   * args(user) 표현식을 통해 타겟 메소드의 인자와 어드바이스의 인자가 매칭된다.
   * updateUser 라는 포인트컷이 user 라는 인자를 사용하도록 args(user) 표현식으로 지정한 것이다.
   *
   * @param user
   */
  @Pointcut("execution(* com.springboot.aop.service.UserService.update(*)) && args(user)")
  public void updateUser(User user) {}

  /**
   * '@AfterReturning' 을 통해 정상적으로 타겟 메소드가 실행 된 후, DB 에 저장되도록 함
   * @param user
   */
  @AfterReturning("updateUser(user)")
  public void saveHistory(User user) {
    historyRepository.save(new History(user.getIdx()));
  }

}
