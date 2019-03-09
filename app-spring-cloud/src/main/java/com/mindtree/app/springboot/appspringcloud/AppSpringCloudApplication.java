package com.mindtree.app.springboot.appspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class AppSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringCloudApplication.class, args);
	}

}
