package com.paulhoang;

import com.paulhoang.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  @Autowired
  private MyService myService;

  public static void main(String[] args) {

    System.out.println("BLAH BLAH");
    SpringApplication.run(Application.class, args);
  }

  @RequestMapping(value = "/blah")
  public String blah() {
    return "blah";
  }


  @RequestMapping(value = "/very-heavy-compute")
  public String veryHeavyCompute() {
    return myService.someVeryComputeIntensiveMethod().toString();
  }

}
