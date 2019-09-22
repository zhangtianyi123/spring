package zty.practise.originalSpring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AOPConfig {

	@Bean
	public Coder coder() {
		return new Coder(computer());
	}
	
	@Bean
	public Computer computer() {
		return new Computer();
	}
}
