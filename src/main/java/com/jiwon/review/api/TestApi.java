package com.jiwon.review.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

  @GetMapping("/hello/world")
  public String getHelloWorld() {
    return "[Get] Hello, World";
  }

  @PostMapping("/hello/world")
  public String postHelloWorld() {
    return "[Post] Hello, World";
  }

  @PutMapping("/hello/world")
  public String putHelloWorld() {
    return "[Put] Hello, World";
  }

  @DeleteMapping("/hello/world")
  public String deleteHelloWorld() {
    return "[Delete] Hello, World";
  }
}
