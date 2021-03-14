package com.platzi.functional._00_curso;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsStream {

    public static void main(String[] args) {
        IntStream intStream = IntStream.iterate(0, x -> x + 1);
        List<Integer> list = intStream.limit(1000)
                .filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());


    }


}
