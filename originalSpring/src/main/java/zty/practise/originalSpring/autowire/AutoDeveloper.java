package zty.practise.originalSpring.autowire;

import org.springframework.stereotype.Component;

@Component("autoDeveloper")
public class AutoDeveloper {

	public void work() {
		System.out.println("写代码啦！");
	}
}
