package ua.epam.spring.hometask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.User;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class DiscountAspect {

    private static Integer discountsCounter = 0;
    private static Map<User, Integer> discountsPerUser = new HashMap<>();

    @Before("getDiscount()")
    public void countEventAccess(JoinPoint joinPoint) {
        DiscountAspect.discountsCounter++;
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];
        if (discountsPerUser.containsKey(user))
            discountsPerUser.put(user, discountsPerUser.get(user) + 1);
        else
            discountsPerUser.put(user, 1);
    }

    @Pointcut("execution(* ua.epam.spring.hometask.service.implementation.DiscountServiceImpl.getDiscount(..))")
    private void getDiscount() {
    }

}
