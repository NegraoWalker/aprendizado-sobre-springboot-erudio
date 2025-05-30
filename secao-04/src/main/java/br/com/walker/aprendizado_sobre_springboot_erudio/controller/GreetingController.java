package br.com.walker.aprendizado_sobre_springboot_erudio.controller;

import br.com.walker.aprendizado_sobre_springboot_erudio.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping()
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Word") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
