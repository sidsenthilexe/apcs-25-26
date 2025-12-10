public class BruteForce {
    public static void main(String[] args) {

        int[] arr1 = {2, 4, 6, 8};
        int[] arr2 = {1, 3, 5, 7, 9};
        int[] arr3 = {9, -3, 4, 100, 109, 111};
        System.out.println("Shared Values");
        System.out.println(sharedValue(arr1, arr2));
        System.out.println(sharedValue(arr1, arr3));

        int[] arr4 = {3, 1, 3, 2};
        int[] arr5 = {3, 4, 1, 2};
        System.out.println("Duplicate Values");
        System.out.println(duplicateValue(arr4));
        System.out.println(duplicateValue(arr5));

        System.out.println("Sum To Target");
        System.out.println(threeSumToTarget(arr4, 6));
        System.out.println(threeSumToTarget(arr4, 1));

        String[] arr6 = {"walnut", "place", "are", "fire", "blue", "a", "fireplace"};
        System.out.println("Count Compounds");
        System.out.println(countCompounds(arr6));
    }

    public static boolean sharedValue(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) return true;
            }
        }

        return false;
    }

    public static boolean duplicateValue(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }

        return false;
    }

    public static boolean sumToTarget(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) return true;
            }
        }

        return false;
    }

    public static boolean sumToTarget2(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+2; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) return true;
            }
        }

        return false;
    }

    public static boolean threeSumToTarget(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) return true;
                }
            }
        }

        return false;
    }

    public static int countCompounds(String[] words) {
        int countCompounds = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                for (int k = j+1; k < words.length; k++) {

                    String option1 = words[i] + words[j];
                    String option2 = words[j] + words[i];

                    if (option1.equals(words[k]) || option2.equals(words[k])) countCompounds++;

                }
            }
        }

        return countCompounds;
    }

}
