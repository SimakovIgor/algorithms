package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Даны две строки строчных латинских символов: строка J и строка S.
 * Символы, входящие в строку J, — «драгоценности»,
 * входящие в строку S — «камни». Нужно определить, какое количество символов из S одновременно
 * являются «драгоценностями». Проще говоря, нужно проверить, какое количество символов из S входит в J.
 */
public class StonesAndJewelry {

    public static void main(String[] args) {
        System.out.println(stonesAndJewelryHashSet("qedqed", "qweqrtyu"));
    }

    /**
     * Time complexity: O(N*M)
     * Space complexity: O(1)
     */
    public static int stonesAndJewelry(String jewelry, String stones) {
        int res = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewelry.length(); j++) {
                if (stones.charAt(i) == jewelry.charAt(j)) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * Time Complexity O(N+M)
     * Space Complexity O(N) - храним символы из jewelry строки
     */
    public static int stonesAndJewelryHashSet(String jewelry, String stones) {
        Set<Character> jewelryHashSet = new HashSet<>();
        for (int i = 0; i < jewelry.length(); i++) {
            jewelryHashSet.add(jewelry.charAt(i));
        }

        int res = 0;
        for (int j = 0; j < stones.length(); j++) {
            if (jewelryHashSet.contains(stones.charAt(j))) {
                res++;
            }
        }
        return res;
    }

    public static void stonesAndJewelryIndexOf() throws Exception{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String J = r.readLine();
        String S = r.readLine();

        int result = 0;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (J.indexOf(ch) >= 0) {
                ++result;
            }
        }

        System.out.println(result);
    }
}
