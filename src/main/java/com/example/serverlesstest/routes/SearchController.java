package com.example.serverlesstest.routes;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {

  private final RestTemplate template;

  SearchController(RestTemplate template) {
    this.template = template;
  }

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public String search(@RequestParam String query) {
    var entity = template.getForEntity(String.format("https://en.wikipedia.org/wiki/%s", query), String.class);
    return entity.getStatusCode() == HttpStatus.OK ? "success" : "oh snap";
  }
}
