public class Main {
    public static void main(String[] args) {

        int[] test = {5, 2, 3, 1234, 4, 293, 5471, 3948, 38, 1, 5, 8};
        System.out.println(sequentialSearch(test, 5471));
        int[] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 15, 492, 1555};
        System.out.println(binarySearchRecursive(test2, 9));

        for (int n = 100; n < 10000000; n*=2) {
            int[] testArr = testArr(n);
            System.out.println(n + " elements: " + binarySearchTester(testArr));
        }

    }

    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int midIndex = (left + right)/2;
            int midVal = arr[midIndex];
            if (midVal < target) left = midIndex + 1;
            if (midVal > target) right = midIndex - 1;
            if (midVal == target) return midIndex;
        }
        return -1;
    }

    public static int binarySearchTester(int[] arr) {
        int counter = 0;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int midIndex = (left + right)/2;
            counter ++;
            left = midIndex + 1;
        }
        return counter;
    }

    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length-1);
    }

    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int midIndex = (left + right)/2;
        if (target == arr[midIndex]) return midIndex;
        else if (target < arr[midIndex]) return binarySearchHelper(arr, target, left, midIndex-1);
        else return binarySearchHelper(arr, target, midIndex+1, right);
    }

    public static int[] testArr(int length) {
        int[] arr = new int[length];
        arr[0] = (int)(Math.random() * 11);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + (int)(Math.random() * 11);
        }

        return arr;
    }
}
