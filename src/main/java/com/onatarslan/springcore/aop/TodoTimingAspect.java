package com.onatarslan.springcore.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TodoTimingAspect {
    private static final Logger log = LoggerFactory.getLogger(TodoTimingAspect.class);


    @Around(
            "execution(public * " + "com.onatarslan.springcore.todo.TodoService.*(..))"
    )
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startedAt = System.nanoTime();


        try {
            return joinPoint.proceed();
        } finally {
            long elapsedTime = System.nanoTime() - startedAt;

            log.debug("Method {} complated in {} ns", joinPoint.getSignature().toShortString(), elapsedTime);

        }
    }

}
