package com.ddlab.rnd.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages={"com.ddlab.rnd.*"})
public class SpringBootApp {
	
//	@Value("${springfox.documentation.swagger.v2.path}")
//	private String swagger2Endpoint;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}
