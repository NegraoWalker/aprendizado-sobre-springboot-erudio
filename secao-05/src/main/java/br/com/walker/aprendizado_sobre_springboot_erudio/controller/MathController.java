package br.com.walker.aprendizado_sobre_springboot_erudio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.walker.aprendizado_sobre_springboot_erudio.math.SimpleMath.*;


@RestController
@RequestMapping(value = "/math") //http://localhost:8080/math
public class MathController {
    //http://localhost:8080/math/sum/{numberOne}/{numberTwo}
    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(name = "numberOne") String numberOne, @PathVariable(name = "numberTwo") String numberTwo) {
        return addition(numberOne, numberTwo);
    }
    //http://localhost:8080/math/sub/{numberOne}/{numberTwo}
    @GetMapping(value = "/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable(name = "numberOne") String numberOne, @PathVariable(name = "numberTwo") String numberTwo) {
        return subtraction(numberOne, numberTwo);
    }
    //http://localhost:8080/math/mult/{numberOne}/{numberTwo}
    @GetMapping(value = "/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable(name = "numberOne") String numberOne, @PathVariable(name = "numberTwo") String numberTwo) {
        return multiplication(numberOne, numberTwo);
    }
    //http://localhost:8080/math/div/{numberOne}/{numberTwo}
    @GetMapping(value = "/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable(name = "numberOne") String numberOne, @PathVariable(name = "numberTwo") String numberTwo) {
        return division(numberOne, numberTwo);
    }
    //http://localhost:8080/math/mean/{numberOne}/{numberTwo}
    @GetMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable(name = "numberOne") String numberOne, @PathVariable(name = "numberTwo") String numberTwo) {
        return average(numberOne, numberTwo);
    }
    //http://localhost:8080/math/sqrt/{number}
    @GetMapping(value = "/sqrt/{number}")
    public Double sqrt(@PathVariable(name = "number") String number) {
        return squareRoot(number);
    }
}
