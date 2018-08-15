package com.linkinstars.springBootTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * SpringBoot启动类
 * @author LinkinStar
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTemplateApplication.class, args);
	}
}
