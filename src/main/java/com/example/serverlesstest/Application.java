package com.example.serverlesstest;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	@Async("asyncExecutor")
	@RequestMapping("/")
	public CompletableFuture<String> helloWorld() {
		return CompletableFuture.completedFuture("Hello World!");
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
