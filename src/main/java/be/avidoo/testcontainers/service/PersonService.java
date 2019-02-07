package be.avidoo.testcontainers.service;

import be.avidoo.testcontainers.model.Person;
import be.avidoo.testcontainers.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findPersons() {
        return personRepository.findAll();
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }

    public Person create() {

        Person person = Person.builder()
                .firstname("Lebron")
                .lastname("James")
                .birthdate(LocalDate.of(1986, Month.APRIL, 22))
                .build();

        return personRepository.save(person);
    }
}
