package uk.wanat.theclinick;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Start {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello!!";
    }


}
