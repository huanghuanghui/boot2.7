package cn.showcon.boot.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HandleAspect {

	@Pointcut("execution(* cn.showcon.boot.service..*.*(..))")
	public void cutPoint() {
		//@Pointcut 定义切入点
	}


	@Before("cutPoint()")
	public void aopBefore() {
		//@Before 前置通知：目标方法之前执行
		System.out.println("Before");
	}
//
//	@After("cutPoint()")
//	public void aopAfter() {
//		//@After 后置通知：目标方法之后执行（始终执行）
//		System.out.println("After");
//	}
//
//	@AfterReturning("cutPoint()")
//	public void aopAfterReturn() {
//		//@AfterReturning 返回之后通知：执行方法结束之前执行（异常不执行）
//		System.out.println("AfterReturning");
//	}
//
//	@AfterThrowing("cutPoint()")
//	public void aopAfterThrowing() {
//		//@AfterThrowing 异常通知：出香异常后执行
//		System.out.println("AfterThrowing");
//	}
//
//	@Around("cutPoint()")
//	public Object divAround(ProceedingJoinPoint point) throws Throwable {
//		//@Around 环绕通知：环绕目标方法执行
//		System.out.println("Around_a");
//		Object proceed = point.proceed();
//		System.out.println("Around_b");
//		return proceed;
//	}
}

