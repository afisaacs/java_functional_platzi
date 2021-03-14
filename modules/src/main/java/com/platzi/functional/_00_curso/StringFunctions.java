package com.platzi.functional._00_curso;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {

    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";
        System.out.println(quote.apply("Hola estudiante de Platzi"));
        System.out.println(addMark.apply("Hola"));

        BiFunction<Integer, Integer, Integer> plus = (x, y) -> x * y;
        System.out.println(plus.apply(5, 4));

        BinaryOperator<Integer> plusOp = (x, y) -> x * y;
        System.out.println(plusOp.apply(5, 4));

        BiFunction<String, Integer, String> leftPad = (text, number) -> String.format("%" + number + "s", text);
        System.out.println(leftPad.apply("Java", 10));

        List<BiFunction<String, Integer, String>> formateadores = new ArrayList<>();
    }
}
