package zty.practise.originalSpring.autowire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoServer {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(AutoServer.class);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AutoConfig.class);

		AutoLuweiCompany company = ctx.getBean(AutoLuweiCompany.class);
		
		company.code();
		
		logger.info("Auto Application Started.");
	}
}
