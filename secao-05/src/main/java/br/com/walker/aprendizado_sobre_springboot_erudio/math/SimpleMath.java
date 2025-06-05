package br.com.walker.aprendizado_sobre_springboot_erudio.math;

import br.com.walker.aprendizado_sobre_springboot_erudio.exception.UnsupportedMathOperationException;

import static br.com.walker.aprendizado_sobre_springboot_erudio.converter.NumberConverter.convertToDouble;
import static br.com.walker.aprendizado_sobre_springboot_erudio.converter.NumberConverter.isNumeric;

public class SimpleMath {
    public static Double addition(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    public static Double subtraction(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    public static Double multiplication(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    public static Double division(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    public static Double average(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }
    public static Double squareRoot(String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }
}
