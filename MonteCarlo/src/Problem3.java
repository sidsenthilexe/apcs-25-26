/*
Each step - 68 nm
Particle speed - 500 m/s
Particle speed in nm/s - 500,000,000,000
Number of steps per second ~ 7,350,000,000
Equation - f(x) = 60.4*sqrt(x)
Average distance a particle diffuses in 1 second:
~ 5,200,000 nm
~ 0.52 cm
*/


public class Problem3 {
    public static void main(String[] args) {
        displayTable();
    }

    public static void displayTable() {
        for (int i = 0; i <= 400; i++) {
            double avg = avgSimulations(i, 68, 10000);
            double roundedAvg = Math.round(avg * Math.pow(10, 2))/ Math.pow(10,2);
            System.out.println("(" + i + ", " + roundedAvg + ")");
        }
    }

    public static double avgSimulations(int numSteps, int stepMoveDist, int numTests) {
        double sum = 0;
        for (int i = 0; i < numTests; i++) {
            sum += simulateMolecule(numSteps, stepMoveDist);
        }
        return sum/numTests;
    }

    public static double simulateMolecule(int numSteps, int stepMoveDist) {
        double x = 0, y = 0,z = 0;
        for (int i = 0; i < numSteps; i++) {
            double angle1 = Math.random() * 2 * Math.PI;
            double angle2 = Math.random() * 2 * Math.PI;
            x += stepMoveDist * Math.sin(angle1) * Math.cos(angle2);
            y += stepMoveDist * Math.sin(angle1) * Math.cos(angle2);
            z += stepMoveDist * Math.cos(angle1);
        }
        return (Math.sqrt(x*x + y*y + z*z));
    }
}
