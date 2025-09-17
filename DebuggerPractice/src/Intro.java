public class Intro {
    public static void main(String[] args) {
        int count = 0;
        int val = 0;
        int trials = 0;

        do {
            val = (int)(Math.random()*6)+1;
            if (val == 1 || val == 2) count++;
            trials++;
        } while (trials < 10000);

        System.out.println("Probability is " + count/10000);
    }
}
