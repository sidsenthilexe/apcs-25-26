import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test1 = {5, 2, 5, 5, 3, 3, 3, 2, 2, 2, 6, 3, 3, 5};
        int[] test2 = {7, 3, 4, 2, 6, 9, 1, 2};
        int[] test3 = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] test4 = {3};
        int[] test5 = {};

        ArrayList<int[]> tests = new ArrayList<>();
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        tests.add(test5);

        for( int i = 0; i < tests.size(); i++) {
            int[] test = tests.get(i);
            System.out.println("===== Test #" + i + "=========");
            System.out.println("Before: " + Arrays.toString(test));
            reverseInsertionSort(test);
            System.out.println("After: " + Arrays.toString(test));
            System.out.println("================================");
        }

    }

    private static void bubbleSort(int[] arr) {
        boolean swapping;
        do {
            swapping = false;
            for (int i = 0; i + 1 < arr.length; i++) {

                int current = arr[i];
                int next = arr[i + 1];

                if (current > next) {
                    swapping = true;
                    arr[i] = next;
                    arr[i + 1] = current;
                }

            }
        } while (swapping);
    }

    private static void insertionSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int currentVal = arr[index];
            int search = index-1;
            while (search >= 0 && currentVal < arr[search]) {
                arr[search + 1] = arr[search];
                search--;
            }
            arr[search + 1] = currentVal;
        }
    }

    private static void reverseInsertionSort(int[] arr) {
        for (int index = arr.length-2; index >= 0; index--) {
            int currentVal = arr[index];
            int search = index + 1;
            while (search <= arr.length-1 && currentVal > arr[search]) {
                arr[search-1] = arr[search];
                search++;
            }
            arr[search-1] = currentVal;
        }
    }

    private static void selectionSort(int[] arr) {

        for (int target = 0; target < arr.length; target++) {

            int targetValue = arr[target];

            int smallest = arr[target];
            int smallestIndex = target;

            for (int search = target + 1; search < arr.length; search++) {
                if (arr[search] < smallest) {
                    smallest = arr[search];
                    smallestIndex = search;
                }
            }

            arr[smallestIndex] = targetValue;
            arr[target] = smallest;

        }

    }

    private static void selectionSort(String[] arr) {

        for (int target = 0; target < arr.length; target++) {

            String targetValue = arr[target];

            String smallest = arr[target];
            int smallestIndex = target;

            for (int search = target + 1; search < arr.length; search++) {
                if (arr[search].length() < smallest.length()) {
                    smallest = arr[search];
                    smallestIndex = search;
                }
            }

            arr[smallestIndex] = targetValue;
            arr[target] = smallest;
        }

    }
}
