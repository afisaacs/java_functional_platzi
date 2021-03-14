package com.platzi.functional._00_curso;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypeStream {

    public static void main(String[] args) {

        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        long current = System.currentTimeMillis();
        infiniteStream.limit(1000)
                .filter(x -> x % 2 == 0)
//                .allMatch(x -> x % 2 == 0)
                .forEach(System.out::println);
        long time1 = System.currentTimeMillis() - current;

        long current2 = System.currentTimeMillis();
        infiniteStream = IntStream.iterate(0, x -> x + 1);
        infiniteStream.limit(1000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
        long time2 = System.currentTimeMillis() - current2;
        System.out.println("Tiempo sin parallel " + time1);
        System.out.println("Tiempo con parallel " + time2);

        Stream aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        BinaryOperator<String> acumulator = (text1, text2) -> text1 + " " + text2;
        Optional<String> stringOptional = aLongStoryStream.reduce(acumulator);
        stringOptional.ifPresent(System.out::println);

        Stream<Integer> firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
        BinaryOperator<Integer> operatorSum = Integer::sum;
        int sumOfFirstTen = firstTenNumbersStream.reduce(0, operatorSum);
        System.out.println(sumOfFirstTen);
        //45 -> 0 + 1 + … + 9

//        Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
//        BiFunction<Integer, String, Integer> countBiFunction = (count, word) -> count + word.length();
////        BinaryOperator<Integer> sumResult = Integer::sum;
//        BinaryOperator<Integer> sumResult = (x, y) -> x * y;
//        int charCount = aLongStoryStreamAgain.reduce(0, countBiFunction, sumResult);
////        int charCount = aLongStoryStreamAgain.parallel().reduce(0, countBiFunction, sumResult);
//        System.out.println(charCount);
//        //48 -> puede ser usado sin parallel

        Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        int initialValue = 0;
        BiFunction<Integer, String, Integer> countBiFunction = (count, word) -> {
            int result = count + word.length();
            System.out.println("Entro a BiFunction, La longitud " + word + ": " + word.length() + ", valor previo: " + count + ", resultado: " + result);
            return result;
        };
//        BinaryOperator<Integer> sumResult = (x, y) -> {
//            int result = x * y;
//            System.out.println("Reducciones realizadas en paralelo, X: " + x + ",Y: " + y + ", resultado: " + result);
//            return result;
//        };
        BinaryOperator<Integer> sumResult = Integer::sum; // (x, y) -> Integer.sum(x, y);
        int charCount = aLongStoryStreamAgain.reduce(initialValue, countBiFunction, sumResult);
        System.out.println(charCount);



//        Stream<Integer> yearsStream = Stream.of(1990, 1991, 1994, 2000, 2010, 2019, 2020);
//        long yearsCount = yearsStream.count();
//        System.out.println(yearsCount);
        // 7, solo nos dice cuantos datos tuvo el stream.

    }
}
