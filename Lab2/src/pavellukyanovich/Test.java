package pavellukyanovich;
import pavellukyanovich.sentence.Sentences;
import pavellukyanovich.text.Text;
import pavellukyanovich.word.Words;

import java.util.Arrays;

import static pavellukyanovich.sentence.Sentences.*;
import static pavellukyanovich.text.Text.*;
import static pavellukyanovich.word.Words.getLetters;

public class Test {
    public static void main(String[] args) {
        Text txt = new Text();
        System.out.println(getText1());
        txt.splitText();

        Sentences sentence = new Sentences();
        sentence.splitSentence();

        Words word = new Words();
        word.splitWord();

        task1();
        System.out.println(getSentence());

        System.out.println(task2());

        task3();
        System.out.println(getSentence());

        task4('t','e');
        System.out.println(getSentence());

        finalText();
        System.out.println(getText2());

    }
}
