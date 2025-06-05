package br.com.walker.aprendizado_sobre_springboot_erudio.converter;

import br.com.walker.aprendizado_sobre_springboot_erudio.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        String strNumber2 = strNumber.replace(",", ".");
        return strNumber2.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static Double convertToDouble(String strNumber) {
        Double number = 0.0;
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String strNumber2 = strNumber.replace(",", ".");
        if (strNumber2.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            number = Double.parseDouble(strNumber2);
        }
        return number;
    }
}
