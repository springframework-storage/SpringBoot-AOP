package com.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class Performance {

  /**
   * '@Around': 어드바이스
   * - 어드바이스는 '무엇을, 언제' 할지를 의미한다.
   * - 여기서 '무엇'은 calculatePerformanceTime() 메소드
   * - '언제'는 '@Around'가 되는데, 총 5가지의 타입이 존재한다.
   *
   * 1. @Before (이전): 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능 수행
   * 2. @After (이후): 타겟 메소드의 결과에 관계없이(성공, 예외) 타겟 메소드가 완료되면 어드바이스 기능 수행
   * 3. @AfterReturning (정상적 반환 이후): 타겟 메소드가 성공적으로 결과값을 반환 후, 어드바이스 기능 수행
   * 4. @AfterThrowing (예외 발생 이후): 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능 수행
   * 5. @Around (메소드 실행 전후): 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출 전과 후에 어드바이스 기능 수행
   *
   * - 주의할 점: '@Around'의 경우 반드시 proceed() 메소드가 호출되어야 한다.
   * - proceed() 메소드는 타겟 메소드를 지칭하기 때문에 proceed 메소드를 실행시켜야만 타겟 메소드가 수행된다.
   */

  /**
   * "execution(* com.springboot.aop.service.BoardService.getBoards(..))"
   * 어드바이스의 value 로 들어간 위 문자열을 포인트컷 표현식이라고 합니다.
   * - 포인트컷 표현식은 2가지로 나눠지는데, execution 을 지정자, (* com.springboot.~.~.~.getBoards(..)) 는 타겟 명세
   *
   * 포인트컷 지정자는 execution 을 포함하여 9가지가 있습니다.
   *
   * 1. args()
   * - 메소드의 인자가 타겟 명세에 포함된 타입일 경우
   * - ex) args(java.io.Serializable): 하나의 파라미터를 갖고, 그 인자가 Serializable 타입인 모든 메소드
   *
   * 2. @args()
   * - 메소드의 인자가 타겟 명세에 포함된 어노테이션 타입을 갖는 경우
   *
   * 3. execution()
   * - 접근제한자, 리턴타입, 인자타입, 클래스/인터페이스, 메소드명, 파라미터타입, 예외타입 등을 전부 조합 가능한
   *  가장 세심한 지정자
   * - ex) execution(* com.springboot.service.BoardService.*(..): BoardService 인터페이스의 모든 메소드
   *
   * 4. within()
   * - execution 지정자에서 클래스/인터페이스까지만 적용된 경우
   * - 즉, 클래스 혹은 인터페이스 단위까지만 범위 지정이 가능
   * - ex) within(com.springboot.aop.service.*): service 패키지 아래의 클래스와 인터페이스가 가진 모든 메소드
   * - ex) within(com.springboot.aop.service..): service 아래의 모든 하위 패키지까지 포함한 클래스와 인터페이스가 가진 메소드
   *
   * 5. @within()
   * - 주어진 어노테이션을 사용하는 타입으로 선언된 메소드
   *
   * 6. this()
   * - 타겟 메소드가 지정된 빈 타입의 인스턴스인 경우
   *
   * 7. target()
   * - this 와 유사하지만 빈 타입이 아닌 타입의 인스턴스인 경우
   *
   * 8. @target()
   * - 타겟 메소드를 실행하는 객체의 클래스가 타겟 명세에 지정된 타입의 어노테이션이 있는 경우
   *
   * 9. @annotation
   * - 타겟 메소드에 특정 어노테이션이 지정된 경우
   * - ex) @annotation(org.springframework.transaction.annotation.Transactional): Transactional 어노테이션이 지정된 메소드 전부
   */

  /**
   * '@Pointcut' 어노테이션은 애스펙트에서 마치 변수와 같이 재사용 가능한 포인트컷을 정의할 수 있다.
   */
  @Pointcut("execution(* com.springboot.aop.service.BoardService.getBoards(..))")
  public void getBoards() {}

  @Pointcut("execution(* com.springboot.aop.service.UserService.getUsers(..))")
  public void getUsers() {}

  @Around("getBoards() || getUsers()")
  public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
    Object result = null;

    try {
      long start = System.currentTimeMillis();
      result = proceedingJoinPoint.proceed();
      long end = System.currentTimeMillis();

      log.info("*** 수행 시간: {}", end - start);
    } catch (Throwable throwable) {
      log.error("Exception !!");
    }
    return result;
  }

}
