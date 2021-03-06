package io.zwt.messaging.aop;

import io.zwt.messaging.annotation.ToUpper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;
import java.util.stream.IntStream;

@Aspect
@Component
public class CurrencyCodeAudit {

    @Pointcut("execution(* io.zwt.messaging.service.*Service.*(.., @io.zwt.messaging.annotation.ToUpper (*),..))")
    public void methodPointcut() {
    }

    @Around("methodPointcut()")
    public Object codeAudit(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Parameter[] parameters = ((MethodSignature) pjp.getSignature()).getMethod().getParameters();

        return pjp.proceed(IntStream.range(0, args.length)
                .mapToObj(index -> (parameters[index].isAnnotationPresent(ToUpper.class)) ?
                        (args[index].toString().toUpperCase()) : (args[index]))
                .toArray());
    }
}
