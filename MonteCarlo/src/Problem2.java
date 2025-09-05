public class Problem2 {
    public static void main(String[] args) {
        displayTable();
    }

    public static void displayTable() {
        System.out.println("Choco Prob:\tAvg Spins:");
        for (int i = 5; i <= 95; i+=5) {
            System.out.println(i + "%\t\t" + findAvgSpins(10000, i));
        }
    }

    public static double findAvgSpins(int numberTests, double chocoProb) {
        double spinsCounter = 0;
        for (int i = 0; i < numberTests; i++) {
            spinsCounter += spinUntilBothFlavors(chocoProb);
        }
        return (spinsCounter/numberTests);
    }

    public static int spinUntilBothFlavors(double chocoProb) {
        int counter = 0;
        boolean chocolateTried = false, pistachioTried = false;
        do {
            int spin = (int)(Math.random()*101);
            counter++;
            if (spin < chocoProb) chocolateTried = true;
            else pistachioTried = true;
        } while (!chocolateTried || !pistachioTried);
        return counter;
    }

}
