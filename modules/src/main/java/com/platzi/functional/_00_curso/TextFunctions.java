package com.platzi.functional._00_curso;

public class TextFunctions {

    @FunctionalInterface
    interface StringOperation {
        int getAmount();

        default void operate(String text) {
            int x = getAmount();
            while (x-- > 0) {
                System.out.println(text);
            }
        }
    }

    @FunctionalInterface
    interface DoOperation {
        void take(String text);

        default void execute(int x, String text) {
            while (x-- > 0) {
                take(text);
            }
        }

        default void test(int x, String text) {
            while (x-- > 0) {
                take(text);
            }
        }
    }

    public static void main(String[] args) {
        StringOperation six = () -> 6;

        System.out.println(six.getAmount());
        six.operate("Hello");

        DoOperation operateFive = text -> System.out.println(text);
        operateFive.execute(5, "Platzi");
    }
}
