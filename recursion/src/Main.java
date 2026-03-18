public class Main {
    public static void main(String[] args) {

        boolean answer = palindrome("qwertyuiopasdfghjklzxcvbnmmnbvcxzlkjhgfdsapoiuytrewq");
        System.out.println(answer);
    }

    private static long fib(int n) {
        if (n <= 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    private static long fact(int n) {
        if (n == 1) return 1;
        return fact(n-1) * n;
    }

    private static String insertstars(String str) {
        if (str.length() == 1) return str;
        if (str.length() == 2) return str.charAt(0) + "*" + str.charAt(1);
        int middle = str.length() / 2;
        return insertstars(str.substring(0, middle)) + "*" + insertstars(str.substring(middle));
    }

    private static boolean palindrome(String str) {
        if (str.length() == 1) return true;
        if (str.length() == 2) return (str.charAt(0) == str.charAt(1));
        boolean startEnd = str.charAt(0) == str.charAt(str.length()-1);
        return startEnd && palindrome(str.substring(1, str.length()-1));
    }
}
