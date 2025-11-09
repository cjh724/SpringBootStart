package hello.springbootstart.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component      // SpringConfig 설정이 아닌 Component Scan 방식 적용
public class TimeTraceAop {

    @Around("execution(* hello.springbootstart..*(..))")
    public Object execute( ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());

        try {
            return joinPoint.proceed();     // 다음 메소드로 진행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " | " + timeMs + " ms");
        }
    }

}
