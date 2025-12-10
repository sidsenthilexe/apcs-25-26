import java.util.ArrayList;

public class BruteForceChallenge {
    public static void main(String[] args) {
        displayTable();
    }

    public static void displayTable() {
        int count60 = 0;
        int count20 = 0;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.println(i + " " + j + " " + runCycle(i,j));
            }
        }

    }

    public static int runCycle(int num1, int num2) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        boolean done = false;
        int currentIndex = 2;

        do {
            int thisNum = (list.get(currentIndex-1) + list.get(currentIndex-2)) % 10;
            int prevNum = list.get(currentIndex -1);
            currentIndex++;
            list.add(thisNum);

            if (prevNum == num1 && thisNum == num2) done = true;
        } while (!done);


        return (currentIndex-2);
    }


}


