package edu.uci.ics.cs221.analysis.punctuation;

import edu.uci.ics.cs221.analysis.PunctuationTokenizer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Team4PunctuationTokenizerTest {
    public Team4PunctuationTokenizerTest() {
        System.out.println("Describe: PunctuationTokenizer");
    }

    /**
     * test1 tests if it can deal with empty string
     */
    @Test
    public void test1() {
        System.out.println("It: can deal with empty string");

        String emptyText = "";
        String nullText = null;
        List<String> expected = new ArrayList<>();
        PunctuationTokenizer tokenizer = new PunctuationTokenizer();

        assertEquals(expected, tokenizer.tokenize(emptyText));
        assertEquals(expected, tokenizer.tokenize(nullText));
    }

    /**
     * It: can tokenize normal string with white spaces
     */
    @Test
    public void test2() {
        System.out.println("It: can tokenize normal string with white spaces");

        String text = "I am Happy Today!";
        List<String> expected = Arrays.asList("happy", "today");
        PunctuationTokenizer tokenizer = new PunctuationTokenizer();

        assertEquals(expected, tokenizer.tokenize(text));
    }

    /**
     * test2 tests if it can deal with any punctuations and regard other special characters as normal tokens
     */
    @Test
    public void test3() {
        System.out.println("It: can deal with any punctuations and regard other special characters as normal tokens");

        String Text = "......I am not happy today!? , ) ;";
        List<String> expected = Arrays.asList("happy", "today", ")");
        PunctuationTokenizer tokenizer = new PunctuationTokenizer();

        assertEquals(expected, tokenizer.tokenize(Text));
        //assertEquals(expected, tokenizer.tokenize(nullText));
    }

    /**
     * test4 tests if it could tokenize the string with multiple adjacent white spaces
     * and with spaces before or after the sentence.
     */
    @Test
    public void test4() {
        System.out.println("It: should tokenize the string with multiple adjacent white spaces");

        String text = "   I     am    Happy Today!        ";
        List<String> expected = Arrays.asList("happy", "today");
        PunctuationTokenizer tokenizer = new PunctuationTokenizer();

        assertEquals(expected, tokenizer.tokenize(text));
    }

}
