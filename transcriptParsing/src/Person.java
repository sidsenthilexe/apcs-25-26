import java.util.ArrayList;

public class Person {
    private static String name;
    private static ArrayList<Double> speakLengths;

    public Person(String n) {
        name = n;
        speakLengths = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addSpeak(double seconds) {
        speakLengths.add(seconds);
    }

    public ArrayList<Double> getSpeakLengths () {
        return speakLengths;
    }
}
