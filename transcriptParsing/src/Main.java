import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> file = readFile("src/short-test-transcript.vtt");

        double speakingTime = 0;

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
            System.out.println(name);
            String message = currText.substring(currText.indexOf(":")+2);

            boolean inList = false;
            int thisPersonIndex = 0;

            for (int j = 0; j < people.size(); j++) {
                if (people.get(j).getName().equals(name)) {
                    inList = true;
                    thisPersonIndex = j;
                    break;
                }
            }



            if (!inList) {
                people.add(new Person(name));
                thisPersonIndex = people.size()-1;
            }

            Person currPerson = people.get(thisPersonIndex);
            currPerson.addSpeak(end-start);



        }

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).getName());
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
