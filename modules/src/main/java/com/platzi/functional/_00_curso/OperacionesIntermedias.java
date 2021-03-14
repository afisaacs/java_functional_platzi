package com.platzi.functional._00_curso;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacionesIntermedias {

    public static void main(String[] args) {
        List<Integer> names = Stream.iterate(0, i -> i + 1)
                .limit(100)
                .collect(Collectors.toList());

        Comparator<Integer> comp = Integer::compare;
        names.stream()
                .sorted(comp)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .forEach(System.out::println);;

    }
}
