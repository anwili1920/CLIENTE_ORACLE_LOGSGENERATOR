package com.loggeneratoribm.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 

@SpringBootApplication 
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(DemoApplication.class, args);
		// for(String bean:context.getBeanDefinitionNames()) {
		// 	System.out.println(bean);
		// }
	}

}
