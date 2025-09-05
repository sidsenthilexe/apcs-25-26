public class Problem1b {
    public static void main(String[] args) {
        displayTable();
    }

    public static void displayTable() {
        System.out.println("Goal:\tAvg Bets:");
        for (int i = 55; i <= 245; i+=5) {
            double avgBets = findWinProbability(10000, 50, i);
            System.out.println("$" + i + " " + avgBets);
        }
    }

    public static double findWinProbability(int numberTests, int startingMoney, int goalAmount) {
        double winCounter = 0;
        for (int i = 0; i < numberTests; i++) {
            if (gambleOnce(startingMoney, goalAmount) > 0) winCounter++; // return of gambleOnce will be 0 if failed and goal otherwise
        }
        return (winCounter/numberTests);
    }

    public static int gambleOnce(int startingMoney, int goalAmount) {
        int money = startingMoney;
        do {
            int betOutcome = (int)(Math.random() *2);
            if (betOutcome == 0) money--;
            else money++;
        } while (money >= 0 && money <= goalAmount);
        return money;
    }
}

