package com.accolite.kaisehai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import com.accolite.kaisehai.config.RabbitMQConfig;
import com.accolite.kaisehai.config.RedisConfig;

@SpringBootApplication
@EnableCaching
@Import({RedisConfig.class, RabbitMQConfig.class})
public class KaisehaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaisehaiApplication.class, args);
	}

}
