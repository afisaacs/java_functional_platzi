package com.platzi.functional._00_curso;

import java.util.List;
import java.util.function.Function;

public class Inference {

    public static void main(String[] args) {
        Function<Integer, String> converter = integer -> "Al doble " + integer * 2;

        List<String> alumnos = NombresUtils.getList("Hugo", "Paco", "Luis");
        alumnos.forEach(System.out::println);

    }

}
