package zty.practise.originalSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import zty.practise.originalSpring.beans.LuweiCompany;

public class LuweiServer {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(LuweiServer.class);

		String path = "classpath*:spring-config.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(path);

		LuweiCompany com = ctx.getBean(LuweiCompany.class);
		com.code();

		logger.info("Application(xmlconfig)  Started.");

	}
}
