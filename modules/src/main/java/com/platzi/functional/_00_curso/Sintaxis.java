package com.platzi.functional._00_curso;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {

    @FunctionalInterface
    interface ZeroArguments {
        int get();
    }

    @FunctionalInterface
    interface Nada {
        void nada();
    }

    static void usarZero(ZeroArguments zeroArguments) {

    }

    static void usarPredicado(Predicate<String> predicado) {

    }

    static void usarBiFunction(BiFunction<Integer, Integer, Integer> operacion) {

    }

    static void usarNada(Nada nada) {

    }

    public static void main(String[] args) {
        List<String> cursos = NombresUtils.getList("Java", "Functional");
        cursos.forEach(curso -> System.out.println(curso));

        BiFunction<Integer, Integer, Integer> s = (x, y) -> x * y;

        usarZero(() -> 2);

        usarPredicado(text -> text.isEmpty());

        usarBiFunction((x, y) -> x * y);

        usarBiFunction((x, y) -> {
            System.out.println("X: " + x + ", Y" + y);
            return x - y;
        });

        usarNada(() -> {
            System.out.println("Hola almuno");
        });

        usarBiFunction((Integer x, Integer y) -> x * y);
    }

}
