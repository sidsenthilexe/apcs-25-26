public class Problem5 {
    public static void main(String[] args) {
        String[][] arrayToTranspose = {{"a","b","c","d","e"},
                                       {"f","g","h","i","j"},
                                       {"k","l","m","n","o"}};

        Main.cleanPrintArray(arrayToTranspose);

        String[][] transposed = transpose(arrayToTranspose);
        Main.cleanPrintArray(transposed);
    }

    public static String[][] transpose(String[][] arr) {
        String[][] newArray = new String[arr[0].length-1][arr.length-1];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                String val = arr[row][col];
                System.out.println(val);
                newArray[col][row] = val;
            }
        }

        return newArray;
    }
}
