package cn.heweiming.up.aspect;

import org.aspectj.lang.JoinPoint;

//@Aspect
//@Component
public class LogAspect {

//	@Pointcut("execution(* cn.heweiming.up..*.*(..))")
	public void pointcut() {
	};

//	@Before(value = "pointcut()")
	public void before(JoinPoint joinPoint) {
		System.out.println("执行方法 ==>\t"+joinPoint.getSignature());
	}

//	@After(value = "pointcut()")
//	public void after(JoinPoint joinPoint) {
//		System.out.println(joinPoint);
//		System.out.println("在方法之后执行");
//	}
}
