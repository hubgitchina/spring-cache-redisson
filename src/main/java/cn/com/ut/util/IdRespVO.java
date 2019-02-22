package cn.com.ut.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wuxiaohua
 * @since 2018/10/24
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class IdRespVO {
	private String id;

	public IdRespVO(String id) {

		this.id = id;
	}
}
