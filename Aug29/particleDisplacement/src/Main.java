public class Main {
    public static void main(String[] args) {
        displayTable();
    }

    public static void displayTable() {
        for (int i = 1; i <= 50; i++) {
            double answer = calcAverage(i);
            System.out.println(i + " random steps have average displacement " + answer);
        }
    }

    public static double calcAverage(int numSteps) {
        double sum = 0.0;
        for (int i = 0; i < 10000; i++) {
            sum += doExperiment(numSteps);
        }
        return (sum/10000);
    }

    public static double doExperiment(int numSteps) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < numSteps; i++) {
            int moveDirection = (int)(Math.random()*3);
            if (moveDirection == 0) y++;
            else if (moveDirection == 1) x++;
            else if (moveDirection == 2) y--;
            else if (moveDirection == 3) x--;
        }
        return Math.hypot(x,y);
    }
}