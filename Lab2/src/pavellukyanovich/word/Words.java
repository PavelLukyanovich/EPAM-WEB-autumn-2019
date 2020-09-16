package pavellukyanovich.word;
import pavellukyanovich.sentence.Sentences;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {
    private static String letterFromWord = Sentences.getWords().toString();
    private static String  letter;

    private static ArrayList<String> letters = new ArrayList<String>();

    public static String getLetter() {
        return letter;
    }

    public static ArrayList<String> getLetters() {
        return letters;
    }

    public static void splitWord(){
        String regex = "[\\w]|[.!?;]";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(letterFromWord);
        while (m1.find()){
            letter = m1.group();
            letters.add(letter);
        }

    }
}
