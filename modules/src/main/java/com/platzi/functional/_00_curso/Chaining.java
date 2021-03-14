package com.platzi.functional._00_curso;

public class Chaining {

    static class Chainer {

        public Chainer sayHi() {
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye() {
            System.out.println("Adiós");
            return this;
        }

    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Hola")
                .append("alumno")
                .append("de")
                .append("platzi");

        Chainer chainer = new Chainer();
        Chainer chainer1 = chainer.sayHi();
        Chainer chainer2 = chainer.sayBye();
    }
}
