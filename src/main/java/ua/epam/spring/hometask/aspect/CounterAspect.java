package ua.epam.spring.hometask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Event;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CounterAspect {

    private static int COUNTER = 1;
    public static Map<String, Integer> eventAccessCounter = new HashMap<>();
    public static Map<Event, Integer> eventPriceAccessCounter = new HashMap<>();
    public static Map<String, Integer> eventTicketBookingCounter = new HashMap<>();

    @Before("allMethods()")
    public void countEventAccess(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getSimpleName());
        CounterAspect.COUNTER++;
        System.out.println(COUNTER);
        System.out.println("dupa");
    }

    @Pointcut("execution(public * *(..))")
    private void allMethods() {
        System.out.println("pointcut");
    }
}