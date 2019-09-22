package zty.practise.originalSpring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("autoLuweiCompany")
public class AutoLuweiCompany {

	@Autowired
	private AutoDeveloper autodeveloper;
    
    public void code() {
    	autodeveloper.work();
    }
}
