package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Даны две строки, состоящие из строчных латинских букв. Требуется определить, являются ли эти строки анаграммами,
 * т. е. отличаются ли они только порядком следования символов.
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram3("aquis", "aqius"));
        System.out.println(isAnagram3("aquii", "aqius"));
    }

    /**
     * Решение  reverse string
     */
    public static boolean isAnagram3(String s1, String s2) {
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

    public static boolean isAnagram2(String s1, String s2) {
        return mapFromString(s1).equals(mapFromString(s2));
    }

    public static Map<Character, Integer> mapFromString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        return map;
    }
}
