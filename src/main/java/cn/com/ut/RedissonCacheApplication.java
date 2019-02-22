package cn.com.ut;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//@EnableDiscoveryClient
@SpringBootApplication
public class RedissonCacheApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(RedissonCacheApplication.class).web(true).run(args);
	}
}
