public class Main {
    public static void main(String[] args) {

        long answer = fact(4);
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
}
