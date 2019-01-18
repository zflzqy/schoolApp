package school.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component  // 为了让spring能扫描得到
@Aspect   // 声明切面
public class LogServiceImplAspect {
    Logger logger = Logger.getLogger(LogServiceImplAspect.class);
    String logStr = null;

    // 声明切点 *所有方法是（..）
    @Pointcut("execution(* school.service.*.*(..))")
    public void pointCut() {
    }

    // 拦截执行方法之前 // pointCut()等同于execution(* com.ssm.di.service.*.*(..))
    @Before(value = "pointCut())")
    public void doBefore(JoinPoint joinPoint) {
        // JoinPoint连接点，程序执行的点，相当于程序的方法
        // 拿到访问者的信息
        // 拿到了方法的名称
        logStr = joinPoint.getTarget().getClass().getName() + " 类的 "
                + joinPoint.getSignature().getName() + " 方法开始执行 ";
        //传入的参数值
        Object[] arguments = joinPoint.getArgs();
        logStr+="参数列表:";
       for (int i=0;i<arguments.length;i++){
           if (arguments[i] instanceof Object){
               // 如果是对象
               logStr+="第"+i+"个参数:"+arguments[i].toString();
           }else {
                logStr+="第"+i+"个参数:"+arguments[i];
           }
           logStr+="        ";
       }
        logger.info(logStr);
    }

    // 拦截执行方法之后
    @After(value = "pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logStr = joinPoint.getTarget().getClass().getName() + " 类的 "
                + joinPoint.getSignature().getName() + " 方法执行结束";
        logger.info(logStr);
    }

    // 拦截在方法返回了返回值之后 注解的result必须与参数result一致
    @AfterReturning(value = "pointCut()", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, Object result) {
        logStr = " 拦截返回值：" + result;
        logger.info(logStr);
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
        try {
            rs = joinPoint.proceed();// 推进方法执行
        } catch (Throwable throwable) {
            System.out.println("service方法异常：");
            throwable.printStackTrace();
            logStr = "方法：" + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName() + "()  ";
            logStr += logStr + "错误信息如下：[" + throwable.toString() + "]";
            logger.info(logStr);
        }
        return rs;
    }
}
