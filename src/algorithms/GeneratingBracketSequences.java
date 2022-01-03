package algorithms;

import java.util.Arrays;

/**
 * Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 * n,
 * упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).
 * В задаче используются только круглые скобки.
 */
public class GeneratingBracketSequences {
    public static void main(String[] args) {
        int n = 3;
        int k = n * 2;
        generate(0, new char[k], 0, k);
    }

    /*
     * В этом способе предполагается, что мы начинаем перебирать последовательности с пустого списка. После того, как
     * в список добавлена скобка (открывающая или закрывающая), снова выполняется вызов рекурсии и проверка условий.
     * Какие могут быть условия? Необходимо следить за разницей между открывающими и закрывающими скобками
     * (переменная diff) — нельзя добавить закрывающую скобку в список, если эта разница не является положительной,
     * иначе скобочная последовательность перестанет быть правильной. Осталось аккуратно реализовать это в коде.
     */
    public static void generate(int diff, char[] brackets, int index, int k) {
        if (diff <= k - index - 1) {
            brackets[index] = '(';
            generate(diff + 1, brackets, index + 1, k);
        }
        if (diff > 0) {
            brackets[index] = ')';
            generate(diff - 1, brackets, index + 1, k);
        }
        if (index == k && diff == 0)
            System.out.println(Arrays.toString(brackets));
    }

}
