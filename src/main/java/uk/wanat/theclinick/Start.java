package uk.wanat.theclinick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Start {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/hello")
    public String sayHello(){
        return "hello!!";
    }
    @GetMapping("/show")
    public Person addPerson(){
        Person person = new Person("James");
        return personRepository.save(person);
    }

}
