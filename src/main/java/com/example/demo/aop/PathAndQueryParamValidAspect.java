package com.example.demo.aop;

import com.example.demo.annotation.ParameterValid;
import com.example.demo.annotation.PathAndQueryParamValid;
import com.example.demo.entity.Response;
import com.example.demo.expception.ParameterValidException;
import com.example.demo.utils.AdvanceResponseSupport;
import javassist.NotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.List;

@Aspect
@Component
public class PathAndQueryParamValidAspect {

  private static final Logger logger = LoggerFactory.getLogger(PathAndQueryParamValidAspect.class);

    public PathAndQueryParamValidAspect() {
        logger.info("=============初始化AOP===============");
    }
  //@Pointcut()
  @Before("execution (public * *(..)) && @annotation(paramValid)")
  public void paramValid(JoinPoint joinPoint, PathAndQueryParamValid paramValid) {
      String className = joinPoint.getTarget().getClass().getName();
      String methodName = joinPoint.getSignature().getName();
      Object[] param = joinPoint.getArgs();
      try {
          List<String> errorLists = ParamValidSupport.get().validate(className, methodName,
                  ParameterValid.class, param);
          logger.info("a");
          if (errorLists != null) {
              AdvanceResponseSupport.advanceResponse(new Response(404));
           }
      } catch (NotFoundException | ClassNotFoundException | ParameterValidException e) {
          logger.error("e-name：" + e.getClass().getName() + "： message：" + e.getMessage());
      }
  }
}