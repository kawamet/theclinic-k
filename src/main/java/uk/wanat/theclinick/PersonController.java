package uk.wanat.theclinick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/add")
    public Person addPerson(){
        Person person = new Person("James");
        return personRepository.save(person);
    }
}
