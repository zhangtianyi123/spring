package zty.practise.originalSpring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class HelloService {

	@Autowired
	private HelloMapper helloMapper;
	
	public LotInfo getLotInfo() throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
		LotInfo lot = helloMapper.getLotFromDB();
		return lot;
//		String jsonString = mapper.writeValueAsString(lot);
//		
//		return jsonString;
	}
}
