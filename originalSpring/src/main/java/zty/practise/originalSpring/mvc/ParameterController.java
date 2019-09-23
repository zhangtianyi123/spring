package zty.practise.originalSpring.mvc;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/parameter")
public class ParameterController {

	@RequestMapping("/query")
	public String query(@RequestParam("company")String company, @RequestParam("employee")String employee) throws JsonProcessingException {
		return company + "\'s " + employee;
	}
	
	@RequestMapping("/path/{company}/{employee}")
	public String path(@PathVariable String company, @PathVariable String employee) throws JsonProcessingException {
		return company + "\'s " + employee;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/body")
	public LotInfo body(@RequestBody LotInfo lotInfo) throws JsonProcessingException {
		return lotInfo;
	}
}
