package br.com.walker.aprendizado_sobre_springboot_erudio.controller;

import br.com.walker.aprendizado_sobre_springboot_erudio.model.dto.PersonDTO;
import br.com.walker.aprendizado_sobre_springboot_erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{id}")
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @PutMapping
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return personService.update(personDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personService.delete(id);
    }

}
