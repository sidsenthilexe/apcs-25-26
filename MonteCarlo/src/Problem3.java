public class Problem3 {

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
