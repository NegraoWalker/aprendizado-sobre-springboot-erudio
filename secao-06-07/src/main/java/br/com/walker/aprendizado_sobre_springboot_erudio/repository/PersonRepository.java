package br.com.walker.aprendizado_sobre_springboot_erudio.repository;

import br.com.walker.aprendizado_sobre_springboot_erudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
