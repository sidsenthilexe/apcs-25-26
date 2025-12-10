import java.util.ArrayList;

public class Person {
    private final String name;
    private final ArrayList<Double> speakLengths;

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

    public String toString() { return name; }
}
