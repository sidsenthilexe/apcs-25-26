import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> file = readFile("src/ChitChat01.vtt");

        double speakingTime = 0;
        int speakerSwitches = 0;

        ArrayList<String> times = new ArrayList<>();
        ArrayList<String> text = new ArrayList<>();

        ArrayList<Person> people = new ArrayList<>();

        for (int i = 3; i < file.size(); i+=4) {
            times.add(file.get(i));
        }

        for (int i = 4; i < file.size(); i+=4) {
            text.add(file.get(i));
        }

        for (int i = 0; i < times.size(); i++) {
            String currTime = times.get(i);
            String currText = text.get(i);

            String startTime = currTime.substring(0, currTime.indexOf(" "));
            String endTime = currTime.substring(currTime.indexOf(">")+2);

            double start = getSeconds(startTime);
            double end = getSeconds(endTime);

            String name = currText.substring(0, currText.indexOf(":"));
            String message = currText.substring(currText.indexOf(":")+2);

            boolean inList = false;
            int thisPersonIndex = 0;

            if(!getNameFromText(text.get(Math.max(0,i-1))).equals(name)) speakerSwitches++;

            for (int j = 0; j < people.size(); j++) {
                if (people.get(j).getName().equals(name)) {
                    inList = true;
                    thisPersonIndex = j;
                    break;
                }
            }

            if (!inList) {
                Person newPerson = new Person(name);
                people.add(newPerson);
                thisPersonIndex = people.size()-1;
            }

            Person currPerson = people.get(thisPersonIndex);
            currPerson.addSpeak(end-start);
        }


        double totalTimeSpeaking = 0;
        for(Person p : people){
            ArrayList<Double> speakingTimes = p.getSpeakLengths();
            double thisPersonSpeaking = 0;
            for(Double d : speakingTimes){
                thisPersonSpeaking += d;
            }

            totalTimeSpeaking += thisPersonSpeaking;
        }
        System.out.println("Total speaking time: " + secondsFormatted(totalTimeSpeaking));
        System.out.println("Speaker switches: " + speakerSwitches);

        for(Person p : people){
            ArrayList<Double> speakingTimes = p.getSpeakLengths();
            double thisPersonSpeaking = 0;
            for(Double d : speakingTimes){
                thisPersonSpeaking += d;
            }
            double speakingPercentage = (thisPersonSpeaking/totalTimeSpeaking) * 100;

            System.out.println(p.getName() + ": " + secondsFormatted(thisPersonSpeaking) + ", "+roundDouble(speakingPercentage) + "%");
        }

    }

    public static double getSeconds(String time) {
        double h = Double.parseDouble(time.substring(0, 2));
        double m = Double.parseDouble(time.substring(3, 5));
        double s = Double.parseDouble(time.substring(6));

        s += 60*m;
        s += 3600*h;

        return s;
    }

    public static String secondsFormatted(double seconds) {
        int h = (int) (seconds / 3600);
        seconds = seconds % 3600;
        int m = (int) (seconds / 60);
        seconds = seconds % 60;
        int s = (int) seconds;
        return h + "H:" + m + "M:" + s + "S";
    }

    public static double roundDouble(double old) {
        return (double) Math.round(old * 100) / 100;
    }

    public static String getNameFromText(String text) {
        return text.substring(0, text.indexOf(":"));
    }


    public static ArrayList<String> readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            List<String> contents = Files.readAllLines(Paths.get(filename));
            lines.addAll(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }


}
