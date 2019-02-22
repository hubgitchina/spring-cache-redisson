package cn.com.ut.redis.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.ToString;

@ConfigurationProperties(prefix = "spring.redis", ignoreUnknownFields = false)
@Data
@ToString
public class RedisProperties {

	private int database;

	/**
	 * 等待节点回复命令的时间。该时间从命令发送成功时开始计时
	 */
	private int timeout;

	private String password;

	private String mode;

	/**
	 * 池配置
	 */
	private RedisPoolProperties pool;

	/**
	 * 单机信息配置
	 */
	private RedisSingleProperties single;
}
