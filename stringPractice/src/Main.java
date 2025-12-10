public class Main {
    public static void main(String[] args) {
        System.out.println(shorten("mello"));
        System.out.println(shorten("a"));
        System.out.println(countHi("abc hihi ho"));
        System.out.println(doubleChar("The"));
        System.out.println(doubleChar("AAbb"));
        System.out.println(doubleChar("Hi-There"));
        System.out.println(containBob("abcbob"));
        System.out.println(containBob("b9b"));
    }

    public static String shorten(String str) {
        if (str.length() < 2) return "";
        return str.substring(0,1) + str.substring((str.length()-1));
    }

    public static int countHi(String str){
        int count = 0;
        for (int i = 0; i+2 < str.length() ; i++) {
            if(str.substring(i,i+2).equals("hi")){
                count++;
            }
        }
        return count;
    }

    public static String doubleChar(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            out += str.substring(i, i+1);
            out += str.substring(i, i+1);
        }
        return out;
    }

    public static boolean containBob(String str){
        for (int i = 0; i+2 < str.length() ; i++) {
            if(str.substring(i, i+1).equals("b") && str.substring(i+2,i+3).equals("b")){
                return true;
            }

        }
        return false;
    }

    public static int maxBlock(String str) {
        String blockChar = str.substring(0,1);
        int blockIndex;
        String currentChar;
        int blockCount = 0;
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.substring(i, i+1);
            if (currentChar.equals(blockChar))

        }
    }
}


