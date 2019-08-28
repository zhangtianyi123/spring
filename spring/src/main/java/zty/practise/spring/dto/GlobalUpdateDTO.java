package zty.practise.spring.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class GlobalUpdateDTO implements Serializable {

	private static final long serialVersionUID = 3130745294485497245L;

	/**
	 * 主键id
	 */
	private Long id;
	
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
