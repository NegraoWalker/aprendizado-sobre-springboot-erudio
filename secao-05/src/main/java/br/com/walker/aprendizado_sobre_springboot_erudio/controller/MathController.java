package br.com.walker.aprendizado_sobre_springboot_erudio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/math") //http://localhost:8080/math
public class MathController {
    //http://localhost:8080/math/sum
    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(name = "numberOne") String numberOne, @PathVariable(name = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalArgumentException();
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        String strNumber2 = strNumber.replace(",", ".");
        return strNumber2.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strNumber) {
        Double number = 0.0;
        if (strNumber == null || strNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String strNumber2 = strNumber.replace(",", ".");
        if (strNumber2.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            number = Double.parseDouble(strNumber2);
        }
        return number;
    }


    //http://localhost:8080/math/sub
    //http://localhost:8080/math/div

}
