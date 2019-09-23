package zty.practise.originalSpring.mvc;


import java.io.Serializable; 
public class LotInfo implements Serializable {

	private static final long serialVersionUID = 6753157450715512243L;

	private String lotName;
	
	private String lotPosition;
	
	private String description; 

	public String getLotName() {
		return lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public String getLotPosition() {
		return lotPosition;
	}

	public void setLotPosition(String lotPosition) {
		this.lotPosition = lotPosition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
