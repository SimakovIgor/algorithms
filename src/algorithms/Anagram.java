package algorithms;

import java.util.Arrays;

/**
 * Даны две строки, состоящие из строчных латинских букв. Требуется определить, являются ли эти строки анаграммами,
 * т. е. отличаются ли они только порядком следования символов.
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("aquis", "aqius"));
    }

    /**
     * Решение  reverse string
     */
    public static boolean defineReverse(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        return Arrays.equals(s1Arr, s2Arr);
    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            alphabet[t.charAt(i) - 'a']--;

        for (int i : alphabet)
            if (i != 0)
                return false;
        return true;
    }
}
