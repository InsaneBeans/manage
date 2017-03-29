package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @category 程序运行入口
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class ManageApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ManageApplication.class, args);
	}

}
