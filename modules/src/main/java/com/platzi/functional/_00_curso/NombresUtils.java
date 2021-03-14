package com.platzi.functional._00_curso;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {
    static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }

    public static void main(String[] args) {
        List<String> profesores = getList("Nicolás", "Juan", "Aaron");
        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        System.out.println("///////////////");
        profesores.forEach(nombre -> System.out.println(nombre));

        System.out.println("///////////////");
        profesores.forEach(System.out::println);

    }
}
