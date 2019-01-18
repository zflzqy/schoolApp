package school.aop;

import school.util.DateUtils;
import school.util.HttpContextUtils;
import school.util.IPUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component  // 为了让spring能扫描得到
@Aspect   // 声明切面
public class LogControllerAspect {
    Logger logger = Logger.getLogger(school.aop.LogControllerAspect.class);
    String logStr = null;
    // 声明切点 *所有方法是（..）
    @Pointcut("execution(* school.controller.*.*(..))")
    public  void pointCut(){}

    // 拦截执行方法之前 // pointCut()等同于execution(* com.ssm.di.service.*.*(..))
    @Before(value = "pointCut())")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("controller拦截用户访问信息");
    }

    // 拦截执行方法之后
    @After(value = "pointCut()")
    public void doAfter(JoinPoint joinPoint) {

    }

    // 拦截在方法返回了返回值之后 注解的result必须与参数result一致
    @AfterReturning(value = "pointCut()", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, Object result) {

        return result;
    }

    //    // 在方法抛异常的时候执行
//    @AfterThrowing
//    public void aflterThrowing(){
//
//    }
    // 环绕整个方法的执行
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        // proceedingJoinPoint推进连接点
        Object rs = null;
        // 记录时间
        long beginTime = System.currentTimeMillis();
        try {
            rs = joinPoint.proceed();// 推进方法执行
        } catch (Throwable throwable) {
            System.out.println("service方法异常：");
            throwable.printStackTrace();
            logStr = "方法：" + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + "()  ";
            logStr += logStr + "错误信息如下：[" + throwable.toString() + "]";
            logger.info(logStr);
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(joinPoint, time);
        return rs;
    }
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 记录IP地址
        logStr="用户访问ip:"+ IPUtils.getIpAddr(request)+"    ";
        // 记录操作时间
        logStr+="操作的日期:"+ DateUtils.getStrByDate(new Date(),"yyyy-MM-dd HH:mm:ss") +"  操作耗时"+time+"毫秒";
        logger.info(logStr);
    }
}
