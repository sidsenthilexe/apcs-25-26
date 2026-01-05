import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] intArray = createArray(5,5,5);
        String[][] strArray = createArray(4,3,"hello");

        System.out.println(Arrays.deepToString(intArray));
        System.out.println(Arrays.deepToString(strArray));

    }

    public static int[][] createBorderArray(int width, int height, int val) {
        int[][] arr = new int[height][width];
        for (int row = 0; row < arr.length; row++) {
            if(row == 0 || row == arr.length-1);
        }
    }


    public static int[][] createArray(int width, int height, int initialValue) {
        int[][] arr = new int[height][width];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] = initialValue;
            }
        }

        return arr;
    }

    public static String[][] createArray(int width, int height, String initialValue) {
        String[][] arr = new String[height][width];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] = initialValue;
            }
        }

        return arr;
    }



}