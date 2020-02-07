package io.zwt.messaging.aop;

import io.zwt.messaging.event.CurrencyConversionEvent;
import io.zwt.messaging.exception.BadCodeRuntimeException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrencyConversionAudit {

    private ApplicationEventPublisher publisher;


    public CurrencyConversionAudit(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Pointcut("execution(* io.zwt.messaging.service.*Service.*(..))")
    public void exceptionPointcut() {
    }

    @AfterThrowing(pointcut = "exceptionPointcut()", throwing = "ex")
    public void badCodeException(JoinPoint jp,
                                 BadCodeRuntimeException ex) {
        if (ex.getConversion() != null) {
            publisher.publishEvent(
                    new CurrencyConversionEvent(
                            jp.getTarget(),
                            ex.getMessage(),
                            ex.getConversion()));
        }
    }
}
