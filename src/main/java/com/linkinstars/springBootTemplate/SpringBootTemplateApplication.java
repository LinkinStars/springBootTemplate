package com.linkinstars.springBootTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * SpringBoot启动类
 * @author LinkinStar
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class SpringBootTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTemplateApplication.class, args);
	}
}
