package zty.practise.spring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import lombok.Data;

@Data
public class GlobalCreateDTO implements Serializable {
	
	private static final long serialVersionUID = 7136372852675856840L;
	
	/**
	 * 查找键
	 */
	private String skey;
	
	/**
	 * 中文
	 */
	private String chinesesMessage;
	
	/**
	 * 英文
	 */
	private String englishMessage;
	
}
