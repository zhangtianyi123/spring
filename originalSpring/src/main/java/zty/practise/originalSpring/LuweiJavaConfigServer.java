package zty.practise.originalSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zty.practise.originalSpring.beans.LuweiCompany;
import zty.practise.originalSpring.config.LuweiConfig;

public class LuweiJavaConfigServer {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LuweiJavaConfigServer.class);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(LuweiConfig.class);

		LuweiCompany company = ctx.getBean(LuweiCompany.class);
		
		company.code();
		
		logger.info("Application(Javaconfig) Started.");
	}
}
