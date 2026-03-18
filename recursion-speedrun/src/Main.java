public class Main {
    public static void main(String[] args) {
        System.out.println(doubleChars("abc"));
        System.out.println(reverseString("hello"));
        System.out.println(removeAllX("axbxcxxxx"));
        System.out.println(moveXtoFront("xxrexxx"));
        System.out.println(insertStarBetweenPairs("aaabbbb"));
    }

    private static String doubleChars(String str) {
        if (str.length() <= 1) return str + str;
        return doubleChars(str.substring(0, 1)) + doubleChars(str.substring(1));
    }

    private static String reverseString(String str) {
        if (str.length() <= 1) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    private static String removeAllX(String str) {
        if (str.length() <= 1) {
            if (str.equals("x")) {
                return "";
            } else {
                return str;
            }
        }

        if (str.charAt(0) == 'x') return removeAllX(str.substring(1));
        else return str.charAt(0) + removeAllX(str.substring(1));
    }

    private static String moveXtoFront(String str) {
        if (str.length() <= 1) return str;

        if (str.endsWith("x")) {
            return "x" + moveXtoFront(str.substring(0, str.length() - 1));
        } else {
            return moveXtoFront(str.substring(0, str.length() - 1)) + str.substring(str.length() - 1);
        }
    }

    private static String insertStarBetweenPairs(String str) {
        if (str.length() < 2) return str;
        if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1)) return str.charAt(0) + "*" + str.substring(1);
            else return str;
        }
        return insertStarBetweenPairs(str.substring(0, 2)) + insertStarBetweenPairs(str.substring(2));
    }
}
