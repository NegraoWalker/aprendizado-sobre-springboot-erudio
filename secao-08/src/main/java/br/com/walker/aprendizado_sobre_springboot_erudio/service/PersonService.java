package br.com.walker.aprendizado_sobre_springboot_erudio.service;

import br.com.walker.aprendizado_sobre_springboot_erudio.exception.ResourceNotFoundException;
import br.com.walker.aprendizado_sobre_springboot_erudio.model.Person;
import br.com.walker.aprendizado_sobre_springboot_erudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("Finding all People!");
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        personRepository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        personRepository.deleteById(id);
    }



    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brazil");
        person.setGender("Male | Female");
        return person;
    }
}
