package com.mark.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DBAspect {

    //定义切点
    @Pointcut("execution(* com.mark.Service..*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void Before()
    {
        System.out.println("Before前置增强！");
    }
}
