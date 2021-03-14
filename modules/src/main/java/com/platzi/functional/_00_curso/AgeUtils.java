package com.platzi.functional._00_curso;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {

//    @FunctionalInterface
//    interface BiConsumer {
//        void accept();
//        int accept2();
//    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    public static void main(String[] args) {

        Function<Integer, String> addZeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer, Integer, Integer, LocalDate> parseDateStr = (day, month, year) -> LocalDate.parse(year + "-" + addZeros.apply(month) + "-" + addZeros.apply(day));
        System.out.println(parseDateStr.apply(12, 3, 2021));

        TriFunction<Integer, Integer, Integer, LocalDate> parseDate = (day, month, year) -> LocalDate.of(year, month, day);
        System.out.println(parseDate.apply(12, 3, 2021));

        TriFunction<Integer, Integer, Integer, Integer> calculateAge = (day, month, year) -> Period.between(parseDate.apply(day, month, year), LocalDate.now()).getYears();
        System.out.println(calculateAge.apply(10, 6, 1994));

        TriFunction<Integer, Integer, Integer, Integer> calculateAgeStr = (day, month, year) -> Period.between(parseDateStr.apply(day, month, year), LocalDate.now()).getYears();
        System.out.println(calculateAge.apply(10, 6, 1994));



    }

}
