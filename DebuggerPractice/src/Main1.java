public class Main1 {
    public static void main(String[] args) {
        displayTable();
    }

    public static void displayTable(){
        for (int chanceOfChoc = 5; chanceOfChoc <= 95; chanceOfChoc += 5) {
            double answer = findTheAverage(chanceOfChoc);
            System.out.println("Probability of chocolate: " + chanceOfChoc + "% --> Average number of ice creams: " + answer);
        }
    }

    public static double findTheAverage(double probability){
        double runExperiment = 0;
        for (int i = 0; i < 10000; i++) {
            runExperiment += doExperiment(probability);;
        }
        return runExperiment/10000;
    }

    public static int doExperiment(double probability){
        int numChock = 0;
        int numPist = 0;
        boolean haveBoth = false;
        int howManyTotal = 0;

        do{
            howManyTotal++;
            String result = doOneSpin(probability);
            if (result.equals("Chocolate!")) {
                numChock++;
            }
            if(result.equals("Pistachio!")){
                numPist ++;
            }

            if (numChock >= 1 && numPist >= 1) {
                haveBoth = true;
            }

        } while(!haveBoth);

        return howManyTotal;
    }

    public static String doOneSpin(double probability){
        probability /= 100.0;
        double spinTheWheel = Math.random();
        if(spinTheWheel < probability){
            return "Chocolate!";
        }
        if(spinTheWheel >= probability){
            return "Pistachio!";
        }

        return "Hi";
    }
}
