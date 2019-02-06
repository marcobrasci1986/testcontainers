package be.avidoo.testcontainers.repository;

import be.avidoo.testcontainers.TestcontainersApplication;
import be.avidoo.testcontainers.model.Person;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestcontainersApplication.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest {

    @ClassRule
    public static PostgreSQLContainer postgres = new PostgreSQLContainer();
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    private PersonRepository repository;

    @Test
    public void TEST_SHOULD_LOAD_CONTEXT() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    public void TEST_SHOULD_INSERT_DATA() {
        Person person1 = Person.builder()
                .firstname("Lebron")
                .lastname("James")
                .bithdate(LocalDate.of(1986, Month.APRIL, 22))
                .build();

        Person person2 = Person.builder()
                .firstname("Eden")
                .lastname("Hazdard")
                .bithdate(LocalDate.of(1980, Month.AUGUST, 17))
                .build();


        List<Person> beforeCreate = repository.findAll();
        assertThat(beforeCreate.size(), is(0));

        repository.save(person1);
        repository.save(person2);

        List<Person> afterCreate = repository.findAll();
        assertThat(afterCreate.size(), is(2));
    }
}
