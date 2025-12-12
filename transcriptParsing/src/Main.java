import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // get all .vtt files from the inputs folder
        Path dirPath = Paths.get("inputs/");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath, "*.vtt")) {

            for (Path filePath : stream) {


                // get the current file and read it
                String fileString = filePath.toString();
                String fileName = fileString.substring(fileString.indexOf("\\") + 1, fileString.indexOf("."));

                ArrayList<String> file = readFile(fileString);

                // initialize the out string (contains all output data)
                String out = "";
                out += fileString + "\n\n";

                double speakingTime = 0;
                double meetingTime = 0;
                int speakerSwitches = 0;

                // Split the transcript into lines containing time intervals and lines containing text
                ArrayList<String> times = new ArrayList<>();
                ArrayList<String> text = new ArrayList<>();

                ArrayList<Person> people = new ArrayList<>();

                for (int i = 3; i < file.size(); i += 4) {
                    times.add(file.get(i));
                }

                for (int i = 4; i < file.size(); i += 4) {
                    text.add(file.get(i));
                }

                // Look at each set of time + text
                for (int i = 0; i < times.size(); i++) {
                    String currTime = times.get(i);
                    String currText = text.get(i);

                    // get the start and end time for this line and set the total meeting time if on the last index
                    String startTime = currTime.substring(0, currTime.indexOf(" "));
                    String endTime = currTime.substring(currTime.indexOf(">") + 2);


                    double start = getSeconds(startTime);
                    double end = getSeconds(endTime);
                    if (i == times.size() - 1) {
                        meetingTime = end;
                    }

                    // parse the text part to separate out the name
                    String name = currText.substring(0, currText.indexOf(":"));

                    // Check if the person in this line already exists in the People arraylist, if not create a new one
                    boolean inList = false;
                    int thisPersonIndex = 0;

                    boolean speakerSwitched = false;

                    if (!getNameFromText(text.get(Math.max(0, i - 1))).equals(name)) speakerSwitched = true;

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
                        thisPersonIndex = people.size() - 1;
                    }

                    // get the person object to track all of the data
                    Person currPerson = people.get(thisPersonIndex);
                    currPerson.addSpeak(end - start);

                    if (speakerSwitched) {
                        speakerSwitches ++;
                        currPerson.addSpeakerSwitch();
                    }

                }

                // calculate total speaking time
                double totalTimeSpeaking = 0;
                for (Person p : people) {
                    ArrayList<Double> speakingTimes = p.getSpeakLengths();
                    double thisPersonSpeaking = 0;
                    for (Double d : speakingTimes) {
                        thisPersonSpeaking += d;
                    }

                    totalTimeSpeaking += thisPersonSpeaking;
                }

                out += "Total session time:  " + secondsFormatted(meetingTime) +
                        "\nTotal speaking time: " + secondsFormatted(totalTimeSpeaking) +
                        "\nSpeaker switches:    " + speakerSwitches + "\n";

                // calculate stats for each person
                for (Person p : people) {
                    ArrayList<Double> speakingTimes = p.getSpeakLengths();
                    double thisPersonSpeaking = 0;
                    for (Double d : speakingTimes) {
                        thisPersonSpeaking += d;
                    }
                    double speakingPercentage = (thisPersonSpeaking / totalTimeSpeaking) * 100;

                    double avgSpeakingTime = thisPersonSpeaking / p.getSpeakerSwitches();

                    out += "\n" + p.getName() + ":\n   " +
                            "Total Speaking Time: " + secondsFormatted(thisPersonSpeaking) + "\n   " +
                            "Speaking Percentage: " + roundDouble(speakingPercentage) + "%\n   "+
                            "Avg. Time Until Switch: " + secondsFormatted(avgSpeakingTime) + "\n";
                }

                // out to console and file
                System.out.println(out);
                outToFile(out, fileName);

                System.out.println("\n");
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println("Read Files Error: " + e);
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

    public static void outToFile(String outText, String outFileName) {
        try (PrintWriter writer = new PrintWriter("parseOutputs/" + outFileName + ".txt")) {
            writer.println(outText);
        } catch (IOException e) {
            System.out.println("Print Writer Error: " + e);
        }
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
