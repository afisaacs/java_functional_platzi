package com.platzi.functional._00_curso;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Optionals {
    static List<String> getNames() {
        List<String> list = new LinkedList<>();
        return list;
    }

    static String mostValuablePlayer() {
        return null;
    }

    static int mostExpensiveItem() {
        return -1;
    }

    static Optional<List<String>> getOptionalNames() {
        List<String> namesList = new LinkedList<>();
        // Obtencion de nombres
        return Optional.of(namesList);
    }

    static Optional<String> optionalValuablePlayer() {
//        Retornar un dato del cual desconocemos si es null o no
//        return Optional.ofNullable();
        try {
            return Optional.of("Aaron");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<String> names = getNames();
        if (names != null) {
            // Operar con nombres
        }

        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isPresent()) {

        }
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        Optional<String> optionalValuablePlayer = optionalValuablePlayer();
        String valuablePlayerName = optionalValuablePlayer.orElseGet(() -> "No player");
    }


}
