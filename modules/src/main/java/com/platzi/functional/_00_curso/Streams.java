package com.platzi.functional._00_curso;

import java.util.List;
import java.util.stream.Stream;

public class Streams {

    static <T> Stream<T> addOperator(Stream<T> stream) {
        return stream.peek(data -> System.out.println("Dato: " + data));
    }

    public static void main(String[] args) {
        List<String> courseList = NombresUtils.getList("Java", "Fronted", "Backend", "Full Stack");
        for (String course : courseList) {
            String newCourseName = course.toLowerCase().replace("!", "!!");
            System.out.println("Platzi " + newCourseName);
        }

        Stream<String> courseStream = Stream.of("Java", "Fronted", "Backend", "Full Stack");
//        Stream<Integer> courseLengthStream = courseStream.map(String::length);
//        Optional<Integer> longest = courseLengthStream.max((x, y) -> y - x);
        Stream<String> emphasisCourses = courseStream.map(course -> course + "!");
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(System.out::println);

        Stream<String> courseStream2 = courseList.stream();
//        courseStream2
//                .map(course -> course + "!!")
//                .filter(course -> course.contains("Java"))
//                .forEach(System.out::println);
        addOperator(courseStream2
                .map(course -> course + "!!")
                .filter(course -> course.contains("Java")))
                .forEach(System.out::println);
    }
}
