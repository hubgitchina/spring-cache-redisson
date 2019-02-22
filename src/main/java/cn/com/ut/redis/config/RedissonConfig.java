package cn.com.ut.redis.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
// @EnableConfigurationProperties(RedisProperties.class)
public class RedissonConfig {

	private static final String Address = "redis://192.168.105.80:6379";

	private static final String Password = "";

	// 等待节点回复命令的时间。该时间从命令发送成功时开始计时。
	private static final int Timeout = 3000;

	// 设置对于master节点的连接池中连接数最大为500
	private static final int ConnectionPoolSize = 500;

	private static final int ConnectionMinimumIdleSize = 10;

	// 如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
	private static final int IdleConnectionTimeout = 10000;

	// 同任何节点建立连接时的等待超时。时间单位是毫秒。
	private static final int ConnectTimeout = 30000;

	private static final int PingTimeout = 30000;

	// 当与某个节点的连接断开时，等待与其重新建立连接的时间间隔。时间单位是毫秒。
	private static final int ReconnectionTimeout = 3000;

	/**
	 * 单机模式自动装配
	 *
	 * @return
	 */
	@Bean(destroyMethod = "shutdown")
	RedissonClient redissonSingle() {

		// 创建配置
		Config config = new Config();

		// 指定编码，默认编码为org.redisson.codec.JsonJacksonCodec
		// 之前使用的spring-data-redis，用的客户端jedis，编码为org.springframework.data.redis.serializer.StringRedisSerializer
		// 改用redisson后为了之间数据能兼容，这里修改编码为org.redisson.client.codec.StringCodec
		// config.setCodec(new JsonJacksonCodec());

		// 指定使用单节点部署方式
		SingleServerConfig serverConfig = config.useSingleServer().setAddress(Address)
				.setTimeout(Timeout).setConnectionPoolSize(ConnectionPoolSize)
				.setConnectionMinimumIdleSize(ConnectionMinimumIdleSize)
				.setIdleConnectionTimeout(IdleConnectionTimeout).setPingTimeout(PingTimeout)
				.setConnectTimeout(ConnectTimeout).setReconnectionTimeout(ReconnectionTimeout);

		if (StringUtils.isNotBlank(Password)) {
			// 设置密码
			serverConfig.setPassword(Password);
		}

		// 创建客户端(发现创建RedissonClient非常耗时，基本在2秒-4秒左右)
		return Redisson.create(config);
	}

	// @Bean(destroyMethod = "shutdown")
	// RedissonClient redisson() throws IOException {
	//
	// Config config = new Config();
	// // config.setCodec(new JsonJacksonCodec()); 默认
	// config.useClusterServers().addNodeAddress("redis://192.168.105.80:6379");
	// return Redisson.create(config);
	// }

	// @Autowired
	// RedisProperties redisProperties;
	//
	// @Bean(destroyMethod = "shutdown")
	// RedissonClient redissonSingle() {
	//
	// Config config = new Config();
	// String node = redisProperties.getSingle().getAddress();
	// node = node.startsWith("redis://") ? node : "redis://" + node;
	// SingleServerConfig serverConfig =
	// config.useSingleServer().setAddress(node)
	// .setTimeout(redisProperties.getPool().getConnTimeout())
	// .setConnectionPoolSize(redisProperties.getPool().getSize())
	// .setConnectionMinimumIdleSize(redisProperties.getPool().getMinIdle());
	// if (StringUtils.isNotBlank(redisProperties.getPassword())) {
	// serverConfig.setPassword(redisProperties.getPassword());
	// }
	// return Redisson.create(config);
	// }

	@Bean
	CacheManager cacheManager(RedissonClient redissonClient) {

		Map<String, CacheConfig> config = new HashMap<>(16);
		// 创建一个名称为"goods"的缓存，过期时间ttl为24分钟，同时最长空闲时maxIdleTime为12分钟。
		CacheConfig cacheConfig = new CacheConfig(24 * 60 * 1000, 12 * 60 * 1000);
		config.put("goods", cacheConfig);
		return new RedissonSpringCacheManager(redissonClient, config);
	}

}
