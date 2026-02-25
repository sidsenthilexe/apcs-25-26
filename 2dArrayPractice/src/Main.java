import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] intArray = createArray(5,5,5);
        String[][] strArray = createArray(4,3,"hello");

        int[][] borderArray = createBorderArray(6,7,2);

        cleanPrintArray(intArray);
        printArray(strArray);
        cleanPrintArray(borderArray);
        System.out.println(getMinValue(intArray));
        System.out.println(getMinValueColumn(borderArray));
        System.out.println(getMinInteriorValue(borderArray));

    }

    public static void cleanPrintArray(Object[] arr) {
        System.out.println(Arrays.deepToString(arr).replace("], ", "],\n "));
    }

    public static void printArray(Object[] arr) {
        System.out.println(Arrays.deepToString(arr));
    }

    public static int getMinValue(int[][] arr) {
        int val = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] < val) val = arr[row][col];
            }
        }

        return val;
    }

    public static int getMinValueColumn(int[][] arr) {
        int val = arr[0][0];
        int valCol = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] < val) {
                    val = arr[row][col];
                    valCol = col;
                }
            }
        }

        return valCol;
    }

    public static int getMinInteriorValue(int[][] arr) {
        int val = arr[1][1];
        for (int row = 1; row < arr.length-1; row++) {
            for (int col = 1; col < arr[0].length-1; col++) {
                if (arr[row][col] < val) val = arr[row][col];
            }
        }

        return val;
    }

    public static int[][] createBorderArray(int width, int height, int val) {
        int[][] arr = new int[height][width];
        for (int row = 0; row < arr.length; row++) {
            if(row == 0 || row == arr.length-1) {
                for (int col = 0; col < arr[row].length; col++) {
                    arr[row][col] = val;
                }
            } else {
                arr[row][0] = val;
                arr[row][arr[row].length-1] = val;
            }
        }

        return arr;
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