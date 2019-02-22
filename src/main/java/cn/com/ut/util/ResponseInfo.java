package cn.com.ut.util;

import java.util.Collections;

import org.springframework.data.domain.Page;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ResponseInfo<T> extends RestInfo {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int code = 0;
	private String msg = "success";
	private T data;
	private PageInfo page;
	@JSONField(serialize = false)
	@JsonIgnore
	private boolean snakeCase = true;

	public static ResponseInfo build() {

		ResponseInfo outputData = new ResponseInfo();
		return outputData;
	}

	public ResponseInfo appendSnakeCase(boolean snakeCase) {

		setSnakeCase(snakeCase);
		return this;
	}

	public ResponseInfo appendData(T data) {

		this.setData(data);
		return this;
	}

	public ResponseInfo appendArray(T data) {

		if (data == null)
			this.appendData((T) Collections.emptyList());
		else
			this.appendData(data);
		return this;
	}

	public ResponseInfo appendPage(PageInfo page) {

		this.setPage(page);
		return this;
	}

	public <S> ResponseInfo appendPage(Page<S> page) {

		return this.appendPage(PageInfo.build().appendPage(page));
	}
}
