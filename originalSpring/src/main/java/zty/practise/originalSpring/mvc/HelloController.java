package zty.practise.originalSpring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	/**
	 * @ResponseBody 决定是否被解析为view
	 * @return
	 */
    @RequestMapping("/hello")
//    @ResponseBody
    public String hello(){
        return "hello";
    }

}
