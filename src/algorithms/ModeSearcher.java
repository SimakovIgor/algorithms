package algorithms;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ModeSearcher {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 5, 7, 1, 2};
        System.out.println(findMode(arr));
    }

    public static List<Integer> findMode(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxFrequency = 0;

        for (int j : arr) {
            int value = treeMap.getOrDefault(j, 0) + 1;
            treeMap.put(j, value);
            if (maxFrequency < value) maxFrequency = value;
        }

        int finalMaxFrequency = maxFrequency;

        return treeMap.entrySet().stream()
                .filter(integerIntegerEntry ->
                        integerIntegerEntry.getValue().equals(finalMaxFrequency))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

}
