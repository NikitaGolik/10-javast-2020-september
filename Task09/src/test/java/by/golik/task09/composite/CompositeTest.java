package by.golik.task09.composite;

import by.golik.task09.entity.*;
import by.golik.task09.service.exceptions.IncorrectInputParametersException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;


/**
 * @author Nikita Golik
 */
public class CompositeTest {

    @Test
    public void textCompositeToStringTest2() {

        String expectedText = "Привет. Привет.\n" +
                "Привет. Привет. Привет.\n" +
                "Привет.";

        String fileName = ".\\resources\\data\\paragraph.txt";

    }

    @DataProvider(name = "compositeObjects")
    public Object[][] textCompositeToStringTest() throws IncorrectInputParametersException {
        Symbol s1 = new Symbol('q');
        Symbol s2 = new Symbol('a');

        Symbol s3 = new Symbol('b');
        Symbol s4 = new Symbol('d');

        Symbol s5 = new Symbol('g');
        Symbol s6 = new Symbol('d');

        TextElement word1 = new Word(ComponentType.WORD);
        word1.add(s1);
        word1.add(s2);


        TextElement word2 = new Word(ComponentType.WORD);
        word2.add(s3);
        word2.add(s4);


        TextElement word3 = new Word(ComponentType.WORD);
        word3.add(s5);
        word3.add(s6);


        TextElement lexema1 = new Lexema(ComponentType.LEXEMA);
        lexema1.add(word1);
        TextElement lexema2 = new Lexema(ComponentType.LEXEMA);
        lexema2.add(word2);
        TextElement lexema3 = new Lexema(ComponentType.LEXEMA);
        lexema3.add(word3);

        TextElement sentence1 = new Sentence(ComponentType.SENTENCE);
        sentence1.add(lexema1);
        sentence1.add(lexema2);
        sentence1.add(lexema3);

        TextElement abzats = new Paragraph(ComponentType.PARAGRAPH);
        abzats.add(sentence1);

        TextElement text1 = new Text(ComponentType.TEXT);
        text1.add(abzats);

        return new Object[][]{
                {s1, "q"},
                {word1, "qa"},
                {lexema1, "qa"},
                {sentence1, "qa bd gd "},
                {abzats, "qa bd gd \n    "},
                {text1, "    qa bd gd \n    "}

        };
        }

    @Test(dataProvider = "compositeObjects")
    public void testCompile(TextElement textElement, String result) {
        String line = textElement.toString();
        assertEquals(line,result);
    }

}
