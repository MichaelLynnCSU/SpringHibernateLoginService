package com.mike.bootstrap.mybootstrap;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

// Basically, this tells Spring Boot to start the application by scanning all the classes under ComponentScan.
@SpringBootApplication
@ComponentScan ({"com.mike.bootstrap.mybootstrap.REST", "com.mike.bootstrap.mybootstrap", "com.mike.bootstrap"})
public class MybootstrapApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(MybootstrapApplication.class, args);
	}

}
