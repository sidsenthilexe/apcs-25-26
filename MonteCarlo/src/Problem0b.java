public class Problem0b {
    public static void main(String[] args) {
        displayTable(100);
    }

    public static void displayTable(int upToNumDice) {
        for (int i = 2; i <= upToNumDice; i++) {
            double answer = calcProbability(i, 10000);
            System.out.println(i + ", " + answer);
        }
    }

    public static double calcProbability(int numDice, int numExperiments) {
        int counter = 0;
        for (int i = 0; i < numExperiments; i++) {
            int doExperiment = doExperiment(numDice);
            if (doExperiment % 2 != 0) counter++;
        }
        return ((double) counter / numExperiments);
    }

    public static int doExperiment(int numDice) {
        int counter = 0;
        for (int i = 0; i < numDice; i++) {
            int dieRoll = (int)(Math.random() * 6) + 1;
            if (dieRoll%2 == 0) counter ++;
        }
        return counter;
    }

}

