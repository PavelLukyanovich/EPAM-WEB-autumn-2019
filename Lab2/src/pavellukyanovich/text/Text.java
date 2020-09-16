package pavellukyanovich.text;
import pavellukyanovich.sentence.Sentences;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Text {
    private static String text1 = "\n" +
            "The sun had shifted round, and the myriad windows of the Ministry of Truth, " +
            "with the light no longer shining on them, looked grim as the loopholes of a fortress." +
            " His heart quailed before the enormous pyramidal shape. It was too strong, " +
            "it could not be stormed. A thousand rocket bombs would not batter it down. " +
            "He wondered again for whom he was writing the diary. For the future, for the past" +
            " for an age that might be imaginary! And in front of him there lay not death but annihilation." +
            " The diary would be reduced to ashes and himself to vapour. Only the Thought Police would read" +
            " what he had written, before they wiped it out of existence and out of memory." +
            " How could you make appeal to the future when not a trace of you, not even an anonymous word " +
            "scribbled on a piece of paper, could physically survive?";

    private static String text2;
    private static String strSentence;
    private static ArrayList<String> sentence = new ArrayList<String>();

    public static String getStr () {
        return strSentence;
    }
    public static String getText1() {
        return text1;
    }
    public static String getText2 () {
        return text2;
    }

    public static ArrayList<String> getSentence () {
        return sentence;
    }


    public static void splitText () {
        String regex = "[A-Z][[\\w|,|']*| ]*[.!?]";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(text1);
        while (m1.find()) {
            strSentence = m1.group();
            sentence.add(strSentence);
        }
    }

    public static boolean containWord ( int indexS, int indexW){
        String strS = sentence.get(indexS);
        String strW = Sentences.getWords().get(indexW);

        if (strS.contains(strW)) {
            return true;
        } else
            return false;
    }

    public static String changeWords ( int index0){
        strSentence = sentence.get(index0);
        String newSentence =
                strSentence.replaceAll("([^.!?, ]+)([^.!?]+?)([^.!?, ]+)([.!?])", "$3$2$1$4");
        sentence.set(index0, newSentence);
        return newSentence;
    }

    public static StringBuffer removeSubString ( int index0, int index1, int index2){
        StringBuffer str = new StringBuffer(sentence.get(index0));
        str.delete(index1, index2);
        sentence.set(index0, str.toString());
        return str;
    }
    // This block will solve tasks.

    public static void task1() {
        for (String s : sentence)
            if (s.contains("?")) {
                int index = sentence.indexOf(s);
                String[] str = s.split(" ");
                StringBuilder sb = new StringBuilder();
                for (String r : str) {
                    char firstChar = r.charAt(0);
                    sb.append(r.charAt(0));
                    for (int i = 1; i < r.length(); i++) {
                        if (r.charAt(i) != firstChar) sb.append(r.charAt(i));
                    }
                    sb.append(" ");
                }
                String str1 = sb.toString();
                sentence.set(index, str1);
            }
    }

    public static ArrayList<String> task2() {
        int count = 0;
        ArrayList<String> wordsNotContain = new ArrayList<String>();
        String firstSentence = sentence.get(0);
        String[] fSentence = firstSentence.split("[\\W']+|[.?!;]");
        for (int i = 0; i < fSentence.length; i++) {
            for (int j = 1; j < sentence.size(); j++) {
                if (sentence.get(j).contains(fSentence[i])) {
                    count++;
                }
            }
            if (count == 0) {
                wordsNotContain.add(fSentence[i]);

            }
            count = 0;
        }
        return wordsNotContain;
    }


    public static void task3() {
        String str = "";
        String newStr = "";
        int index = 0;
        for (String s : sentence) {
            if (s.contains("!")) {
                index = sentence.indexOf(s);
                str = s;
            }
        }
        String[] words = str.split("[\\!|\\.|\\?]\\s?");
        String[] wordsResult = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            wordsResult[i] = words[i].trim().replaceAll("(?U)^(\\w+)(.*)(\\b\\w+)([.?!]?$)", "$3$2$1$4");
        }

        for (String s : wordsResult) {
            newStr = String.valueOf(new StringBuilder().append(s)) + "!";
        }
        sentence.set(index, newStr);
    }

    public static  void task4(char ch1, char ch2) {
        int index = 0;
        String str = "";
        for (String s : sentence) {
            if (s.contains(".")) {
                index = sentence.indexOf(s);
                StringBuffer sb = new StringBuffer(s);
                sb.delete(s.indexOf(ch1), s.lastIndexOf(ch2));
                str = sb.toString();
            }
            sentence.set(index, str);
        }
    }
// This method will output final text
    public static void finalText() {
        StringBuilder str = new StringBuilder();
        for(String s : sentence) {
                    str.append((s) + " ");
        }
        text2 = str.toString();
    }
}