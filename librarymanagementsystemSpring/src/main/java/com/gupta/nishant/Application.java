package com.gupta.nishant;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

// Controllers tell that this class should handle incoming requests
@RestController
// Sets the context based on dependencies and currently for spring and web application using tomcat
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.gupta.nishant.Book","com.gupta.nishant.Library", "com.gupta.nishant.Rack"})
public class Application {

//    RequestMapping is the router for the application
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
//        SpringApplication is for bootstrapping our spring application. This is the primary spring component
        SpringApplication.run(Application.class, args);
    }

}