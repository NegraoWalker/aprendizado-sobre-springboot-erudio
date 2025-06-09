package br.com.walker.aprendizado_sobre_springboot_erudio.service;

import br.com.walker.aprendizado_sobre_springboot_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Walker");
        person.setLastName("Negrão");
        person.setAddress("Londrina - Paraná - Brasil");
        person.setGender("Male");
        return person;
    }
}
