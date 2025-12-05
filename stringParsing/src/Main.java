import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> forLoop = splitIntoWordsFor("hello how's it going");
        ArrayList<String> eachLoop = splitIntoWordsEach("hello how's it going");

        for (int i = 0; i < forLoop.size(); i++) {
            System.out.println(forLoop.get(i));
        }

        for (int i = 0; i < eachLoop.size(); i++) {
            System.out.println(eachLoop.get(i));
        }
    }

    public static ArrayList<String> splitIntoWordsFor(String str) {
        String construct = "";

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            String currentChar = str.substring(i, i+1);
            if (currentChar.equals(" ")) {
                words.add(construct);
                construct = "";
            } else construct += currentChar;
        }

        return words;

    }

    public static ArrayList<String> splitIntoWordsEach(String str) {
        ArrayList<String> words = new ArrayList<>();
        int index = -1;

        while (index+1 < str.length()) {
            int nextSpace = str.indexOf(" ", index + 1);
            words.add(str.substring(index+1, nextSpace));
            index = nextSpace + 1;
        }

        return words;
    }
}
