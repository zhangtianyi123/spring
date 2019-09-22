package zty.practise.originalSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPJavaConfigAspect {

	@Pointcut("execution(* zty.practise.originalSpring.aop.Coder.onlyCode(..))")
	public void code() {}
	
	@Before("code()")
	public void startEnv() {
		System.out.println("准备开发环境");
	}
	
	@Around("code()") 
	public void invokeCode(ProceedingJoinPoint jp) {
		try {
			System.out.println("电脑开机");
			jp.proceed();
			System.out.println("电脑关机");
		} catch (Throwable e) {
			System.out.println("电脑坏了，没法工作了");
		}
		
	}
}
