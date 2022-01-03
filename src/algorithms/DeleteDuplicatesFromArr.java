package algorithms;

import java.util.Arrays;

/**
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел. Требуется удалить из него все повторения.
 */
public class DeleteDuplicatesFromArr {
    public static void main(String[] args) {
        int[] s = {0, 0, 0, 1, 1, 2, 3, 4, 4, 4, 5, 6, 7};
        deleteDuplicates(s);
        System.out.println(Arrays.toString(s));

        int[] s1 = {0, 0, 0, 1, 1, 2, 3, 4, 4, 4, 5, 6, 7};
        System.out.println(Arrays.toString(deleteDuplicatesWithExtraSpace(s1)));
    }

    /**
     * Удаляет дубликаты в текущем массиве и возвращает длину отсортированной части
     * Time - On
     * Space - O1
     *
     * @param s - массив для сортировки
     * @return - длина отсортированной части
     */
    public static int deleteDuplicates(int[] s) {
        int j = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[j] != s[i]) s[++j] = s[i];
        }
        return j;
    }

    /**
     * С использованием доп памяти
     * @param s - массив для сортироки
     * @return - новый массив
     * Time - On
     * Space - On
     */
    public static int[] deleteDuplicatesWithExtraSpace(int[] s) {
        int[] res =  new int[s.length];
        for (int i = 0, j = 0; i < s.length; i++) {
            if (res[j] != s[i])
                res[++j] = s[i];
        }

        return res;
    }
}
