package com.kyalo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev, test"));
		var ctx = app.run(args);

//		MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class);
//		System.out.println(myFirstClass.sayHello());

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomPropertyFromMultiple());
//		System.out.println(myFirstService.getJavaVersion());
//		System.out.println(myFirstService.getOSName());
//		System.out.println(myFirstService.getCustomProperty());
	}
}
