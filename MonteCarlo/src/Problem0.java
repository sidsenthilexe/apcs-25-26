public class Problem0 {
    private static final int REPEAT_EXPERIMENT = 10000;

    public static void main(String[] args) {
        displayTable(100);
    }

    public static void displayTable(int upToNumDice) {
        for (int i = 1; i <= upToNumDice; i++) {
            double answer = calcAverage(i);
            System.out.println(i + " dice have average sum of even rolls " + answer);
        }
    }

    public static double calcAverage(int numDice) {
        double sum = 0.0;
        for (int i = 0; i < REPEAT_EXPERIMENT; i++) {
            sum += doExperiment(numDice);
        }
        return (sum / 10000);
    }

    public static double doExperiment(int numDice) {
        int sum = 0;
        for (int i = 0; i < numDice; i++) {
            int dieRoll = (int)(Math.random() * 6) + 1;
            if (dieRoll % 2 == 0) sum += dieRoll;
        }
        return sum;
    }

}

