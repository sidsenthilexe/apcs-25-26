public class Main{
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 0; i < 100; i++) sum += Math.random();
        double avg = sum/100;
        System.out.println(avg);
    }
}