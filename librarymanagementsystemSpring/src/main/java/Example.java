import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

// Controllers tell that this class should handle incoming requests
@RestController
// Sets the context based on dependencies and currently for spring and web application using tomcat
@EnableAutoConfiguration
public class Example {

//    RequestMapping is the router for the application
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
//        SpringApplication is for bootstrapping our spring application. This is the primary spring component
        SpringApplication.run(Example.class, args);
    }

}