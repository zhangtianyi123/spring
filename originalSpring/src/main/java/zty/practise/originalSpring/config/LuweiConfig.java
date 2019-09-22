package zty.practise.originalSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zty.practise.originalSpring.beans.Developer;
import zty.practise.originalSpring.beans.JavaDeveloper;
import zty.practise.originalSpring.beans.LuweiCompany;

@Configuration
public class LuweiConfig {

	@Bean
	public Developer developer() {
		return new JavaDeveloper();
	}

	@Bean
	public LuweiCompany luweiconmany() {
		return new LuweiCompany(developer());
	}
}
