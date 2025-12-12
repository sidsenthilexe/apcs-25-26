import java.util.ArrayList;

public class Person {
    private final String name;
    private final ArrayList<Double> speakLengths;
    private int speakerSwitches;

    public Person(String n) {
        name = n;
        speakLengths = new ArrayList<>();
        speakerSwitches = 0;
    }

    public String getName() { return name; }

    public void addSpeak(double seconds) {
        speakLengths.add(seconds);
    }

    public ArrayList<Double> getSpeakLengths () {
        return speakLengths;
    }

    public String toString() { return name; }

    public void addSpeakerSwitch() { speakerSwitches++; }

    public int getSpeakerSwitches() { return speakerSwitches; }
}
