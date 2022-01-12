package com.worf.worf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.worf.worf"})
public class WorfApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WorfApplication.class, args);
	}

}
