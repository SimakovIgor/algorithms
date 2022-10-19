package problems.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 2, 3, 4, 7, 32, 44, 66};
        System.out.println(binarySearch(arr, 99, 0 ,arr.length));
        System.out.println(binarySearch(arr, -2, 0 ,arr.length));
    }

    public static int binarySearch(int[] arr, int searchFor, int low, int high) {
        int index = -1;

        while (low <= high) {
            int middle = low + ((high - low) / 2);
            if (arr[middle] < searchFor) {
                low = middle + 1;
            } else if (arr[middle] > searchFor){
                high = middle - 1;
            } else if (arr[middle] == searchFor) {
                index = middle;
                break;
            }
        }
        return index;
    }
}
