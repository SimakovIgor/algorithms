package problems;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(calculate(ints));
    }

    /**
     * You are given an integer array height of length n. There are n vertical
     * lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * <p>
     * Find two lines that together with the x-axis form a container, such
     * that the container contains the most water.
     * <p>
     * Return the maximum amount of water a container can store.
     *
     * @param height - ints
     * @return - int
     */
    public static int calculate(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int asn = 0;

        while (leftPointer != rightPointer) {
            int currentMaxWater = min(height[leftPointer], height[rightPointer])
                    * (rightPointer - leftPointer);
            asn = max(asn, currentMaxWater);

            if (height[leftPointer] >= height[rightPointer]) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }
        return asn;
    }

}
