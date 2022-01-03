package algorithms;

/**
 * Даны две строки, состоящие из строчных латинских букв. Требуется определить, являются ли эти строки анаграммами,
 * т. е. отличаются ли они только порядком следования символов.
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(defineReverse("laaal", "laaal"));
        System.out.println(defineReverse("laal", "laaal"));
        System.out.println(defineReverse("laal", "aal"));
        System.out.println(defineReverse("NaN NaN", "NaN NaN"));

        System.out.println(define("laaal", "laaal"));
        System.out.println(define("laal", "laaal"));
        System.out.println(define("laal", "aal"));
        System.out.println(define("NaN NaN", "NaN NaN"));
    }

    /**
     * Решение  reverse string
     */
    public static boolean defineReverse(String s1, String s2) {
        return s1.equals(new StringBuilder(s2).reverse().toString());
    }

    /**
     * Решение через сравнение
     */
    public static boolean define(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;

        for (int i = s2.length() - 1; i > 0; i--) {
            if (s1.charAt(s1.length() - i - 1) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
