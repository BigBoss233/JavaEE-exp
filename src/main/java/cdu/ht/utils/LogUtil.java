package cdu.ht.utils;

import cdu.ht.entity.Admin;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;


@Component
@Aspect
public class LogUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogUtil.class);
    //管理员用户名、具体操作内容、操作时间。

    /*方法调用前，打印入参*/
    @Before(value = "@annotation(cdu.ht.annotation.LogAnno)")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        HttpSession httpSession = (HttpSession) args[0];
        StringBuilder params = new StringBuilder();
        for (Object arg : args) {
            params.append(arg).append(" ");
        }
        if (httpSession.getAttribute("admin") == null) {
            LOGGER.info("【具体操作】:" + className + "#" + methodName);
        } else {
            Admin admin = (Admin) httpSession.getAttribute("admin");
            LOGGER.info("【管理员】:" + admin.getName() + "【具体操作】:" + className + "#" + methodName + params.toString());
        }
    }

    /*过程中检测，catch捕捉到异常后答应日志*/
    @Around(value = "@annotation(cdu.ht.annotation.LogAnno)")
    public Object catchException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            LOGGER.error("在" + className + "的" + methodName + "中发生了异常:{}", e);
            return e;
        }
    }

    /*方法返回之后打印结果*/
    @AfterReturning(value = "@annotation(cdu.ht.annotation.LogAnno)", returning = "returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        HttpSession httpSession = (HttpSession) args[0];
        if (httpSession.getAttribute("admin") == null) {
            LOGGER.info("【具体操作】:" + className + "#" + methodName + "【结果】为:" + JSON.toJSON(returnVal));
        }
//        else {
//            Admin admin = (Admin) httpSession.getAttribute("admin");
//            LOGGER.info("【管理员】:" + admin.getName() + "【具体操作】:" + className + "#" + methodName + "【结果】为:" + JSON.toJSON(returnVal));
//        }
    }
}
