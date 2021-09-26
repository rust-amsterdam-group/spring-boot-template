package com.example.serverlesstest;

import java.util.Map;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	@RequestMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		var app = new SpringApplication(Application.class);
		setCgrConfigIfRequired(app);
		app.run(args);
	}

	private static void setCgrConfigIfRequired(SpringApplication app) {
		if(Strings.isNotBlank(System.getenv("PORT"))){
			app.setDefaultProperties(Map.of(
					"server.port", System.getenv("PORT"),
					"server.address", "0.0.0.0"
					));
		}
	}

}
