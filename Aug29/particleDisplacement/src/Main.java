public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            double avgOfSims = runMultipleSims(i, 10000);
            System.out.println(i + " random steps have average displacement " + avgOfSims);
        }
    }

    public static double simulation(double numSteps) { // how far did it go this simulation
        int x = 0;
        int y = 0;
        for (int i = 0; i < numSteps; i++) {
            int step = (int)(Math.random() * 4);
            if (step == 0) y++;
            else if (step == 1) x++;
            else if (step == 2) y--;
            else if (step == 3) x --;
        }
        return Math.hypot(x,y);
    }

    public static double runMultipleSims(double numStepsToSimulate, double runSimTimes) { // how far did it go on average
        double sumDistance = 0;
        for (int i = 0; i < runSimTimes; i++) {
            sumDistance += simulation(numStepsToSimulate);
        }
        return sumDistance/runSimTimes; // return average (add all the simulations, divide by number of sims)
    }
}