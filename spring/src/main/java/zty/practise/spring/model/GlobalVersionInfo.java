package zty.practise.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;
import tk.mybatis.mapper.annotation.Version;

@Data
@Entity
@Table(name = "GLOBAL_VERSION_INFO")
public class GlobalVersionInfo  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 查找键
	 */
	private String skey;
	
	/**
	 * 中文
	 */
	@Column(name = "CN_MESSAGE")
	private String chinesesMessage;
	
	/**
	 * 英文
	 */
	@Column(name = "EN_MESSAGE")
	private String englishMessage;
	
	/**
	 * 乐观锁版本号
	 */
	@Version
	private Integer version;
	
}
