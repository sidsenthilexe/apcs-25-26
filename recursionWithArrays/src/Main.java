public class Main {
    public static void main(String[] args) {
        int[] testArr = {1, 4, 2, 5, 28, 100, 3, 15, 5};
        int[] sortedArr = {1, 1, 2, 3, 4, 7, 8, 8, 9};

        System.out.println(maxFirst(testArr, 0, testArr.length-1));
        System.out.println(isInOrder(testArr, 0, testArr.length-1));
        System.out.println(isInOrder(sortedArr, 0, sortedArr.length - 1));
    }

    public static int max(int[] arr, int start, int end){
        if (start == end) return arr[start];
        if (end - start == 1) return Math.max(arr[start], arr[end]);

        int mid = (start + end) / 2;
        int leftMax = max(arr, start, mid);
        int rightMax = max(arr, mid + 1, end);

        return Math.max(leftMax, rightMax);
    }

    public static int maxFirst(int[] arr, int start, int end) {
        if (start == end) return arr[start];

        int leftMax = arr[start];
        int rightMax = maxFirst(arr, start+1, end);

        return Math.max(leftMax, rightMax);
    }

    public static boolean isInOrder(int[] arr, int start, int end) {
        if (start == end) return true;
        if (end - start == 1) return arr[start] <= arr[end];

        int mid = (start + end) / 2;
        boolean leftInOrder = isInOrder(arr, start, mid);
        boolean rightInOrder = isInOrder(arr, mid + 1, end);

        return leftInOrder && rightInOrder;

    }

    public static void selectionSort(int[] arr, int start) {

    }


}
