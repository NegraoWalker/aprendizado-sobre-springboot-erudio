package br.com.walker.aprendizado_sobre_springboot_erudio.service;

import br.com.walker.aprendizado_sobre_springboot_erudio.exception.ResourceNotFoundException;
import br.com.walker.aprendizado_sobre_springboot_erudio.mapper.ObjectMapper;
import br.com.walker.aprendizado_sobre_springboot_erudio.model.Person;
import br.com.walker.aprendizado_sobre_springboot_erudio.model.dto.PersonDTO;
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

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        return ObjectMapper.convertListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");
        return ObjectMapper.convertObject(personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!")), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating one Person!");
        Person person = ObjectMapper.convertObject(personDTO, Person.class);
        personRepository.save(person);
        return ObjectMapper.convertObject(person, PersonDTO.class);
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Updating one Person!");
        Person person = ObjectMapper.convertObject(personDTO, Person.class);
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        personRepository.save(entity);
        return ObjectMapper.convertObject(entity, PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        personRepository.deleteById(id);
    }

}
