package zty.practise.originalSpring.mvc;

import org.springframework.stereotype.Repository;

@Repository
public class HelloMapper {

	public LotInfo getLotFromDB() {
		LotInfo lot = new LotInfo();
		fillData(lot);
		return lot;
	}
	
	private void fillData(LotInfo lot) {
		lot.setLotName("L001");
		lot.setLotPosition("1");
		lot.setDescription("this is a model");
	}
}