package pavellukyanovich.sentence;
import pavellukyanovich.text.Text;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentences {

    private static String sentenceFromText = Text.getSentence().toString();
    private static String word;
    private static int length;

    private static ArrayList<String> words = new ArrayList<String>();

    public static String getWord() {
        return word;
    }

    public static ArrayList<String> getWords() {
        return words;
    }

    public static void splitSentence() {
        String regex = "[\\\\w']+|[.?!;]";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(sentenceFromText);
        while (m1.find()) {
            word = m1.group();
            words.add(word);
        }
    }

    public static int getLength(int index) {
        length = getWords().get(index).length();
        return length;
    }

    public static String changeSymbols(int index0, int index1, int index2) {
        word = words.get(index0);
        char[] arr = word.toCharArray();
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        String str = new String(arr);
        words.set(index0, str);
        return word;
    }
}
