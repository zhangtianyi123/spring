package zty.practise.originalSpring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPWithJavaAspectServer {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(AOPWithJavaAspectServer.class);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);

		Coder coder = ctx.getBean(Coder.class);
		
		coder.onlyCode();
		
		logger.info("AOP Application Started.");
	}
}
