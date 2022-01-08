package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 * n,
 * упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).
 * В задаче используются только круглые скобки.
 */
public class GeneratingBracketSequences {
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
    }

    public static void generate(String cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
            System.out.println(cur);
            return;
        }
        if (open < n) generate(cur + "(", open + 1, close, n);
        if (close < open) generate(cur + ")", open, close + 1, n);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate("", 0, 0, n, list);
        return list;
    }

    public static void generate(String cur,  int open, int close, int n, List<String> list) {
        if (cur.length() == 2 * n) {
            list.add(cur);
            return;
        }
        if (open < n) generate(cur + "(", open + 1, close, n, list);
        if (close < open) generate(cur + ")", open, close + 1, n, list);
    }


    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    /**
     * To check whether a sequence is valid, we keep track of balance, the net number of opening brackets minus
     * closing brackets. If it falls below zero at any time, or doesn't end in zero, the sequence is invalid - otherwise it is valid.
     */
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
