package cn.com.ut.util;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestInfo implements Serializable {

	private static final long serialVersionUID = 530962171506984534L;

	@JSONField(serialize = false)
	@JsonIgnore
	protected String userId;

}
