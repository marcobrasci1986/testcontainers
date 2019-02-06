package be.avidoo.testcontainers.controller;

import be.avidoo.testcontainers.model.Person;
import be.avidoo.testcontainers.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;


    @GetMapping(value = "persons")
    public ResponseEntity<List<Person>> findPersons() {
        List<Person> persons = personService.findPersons();

        return ResponseEntity.ok(persons);
    }


    @GetMapping(value = "delete")
    public ResponseEntity<String> initDataset() {
        personService.deleteAll();

        return ResponseEntity.ok("all was deleted");
    }

    @GetMapping(value = "create")
    public ResponseEntity<Person> create() {
        Person person = personService.create();

        return ResponseEntity.ok(person);
    }
}
