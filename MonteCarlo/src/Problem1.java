public class Problem1 {
    public static void main(String[] args) {
        displayTable();
    }

    public static void displayTable() {
        System.out.println("Goal:\tAvg Bets:");
        for (int i = 55; i <= 245; i+=5) {
            double avgBets = findAverageBets(10000, 50, i);
            System.out.println("$" + i + " " + avgBets);
        }
    }

    public static double findAverageBets(int numberTests, int startingMoney, int goalAmount) {
        double sumBets = 0;
        for (int i = 0; i < numberTests; i++) {
            sumBets += gambleOnce(startingMoney, goalAmount);
        }
        return (sumBets/numberTests);
    }

    public static int gambleOnce(int startingMoney, int goalAmount) {
        int money = startingMoney;
        int countBets = 0;
        do {
            int betOutcome = (int)(Math.random() *2);
            if (betOutcome == 0) money--;
            else money++;
            countBets++;
        } while (money >= 0 && money <= goalAmount);
        return countBets;
    }
}
