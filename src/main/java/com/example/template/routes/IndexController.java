package com.example.template.routes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public String helloWorld() {
    return "Hello, world!";
  }
}
