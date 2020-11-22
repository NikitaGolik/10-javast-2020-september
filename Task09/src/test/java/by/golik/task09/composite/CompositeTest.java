package by.golik.task09.composite;

import by.golik.task09.entity.*;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import by.golik.task09.service.handler2.WholeTextParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;


/**
 * @author Nikita Golik
 */
public class CompositeTest {

    @Test
    public void testComp() {

        String wholeText = "Hello hellow";
        String expectedText = "Hello hellow";
        CompositeTextElement textComposite = new CompositeTextElement(ComponentType.SENTENCE);
        new WholeTextParser().parse(textComposite, wholeText);
        String newText = textComposite.toString();
        Assert.assertEquals(newText, expectedText);
    }

    @Test
    public void textCompositeToStringTest() {
        Symbol s1 = new Symbol('a');
        Symbol s2 = new Symbol('b');

        TextElement word1 = new Word(ComponentType.WORD);
        word1.add(s1);
        word1.add(s2);

        String wordText = word1.toString();
        String wordExpectedText = "ab";

        Assert.assertEquals(wordText, wordExpectedText);
    }
    @Test
    public void wordToStringTest() {
        Symbol symbol = new Symbol('a');
        TextElement word1 = new Word(ComponentType.WORD);
        word1.add(symbol);
        TextElement lexema = new Lexema(ComponentType.LEXEMA);
        lexema.add(word1);

        String wordText = lexema.toString();
        String wordExpectedText = "a";

        Assert.assertEquals(wordText, wordExpectedText);

    }
}
