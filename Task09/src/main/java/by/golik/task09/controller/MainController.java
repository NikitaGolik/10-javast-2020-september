package by.golik.task09.controller;

import by.golik.task09.entity.Sentence;
import by.golik.task09.entity.Text;
import by.golik.task09.entity.TextElement;
import by.golik.task09.entity.Word;
import by.golik.task09.service.TextParser;
import by.golik.task09.service.put.FileController;
import by.golik.task09.service.put.InputController;
import by.golik.task09.view.*;
import java.util.HashMap;


/**
 * @author Nikita Golik
 */
public class MainController {



    private static InputController input = new InputController();
    private static Output output = new Output();

    public void startMainMenu() {
        output.printString("Please, input the text file path: ");
        String path = input.getFilePath();

        Text text = TextParser.parseText(FileController.getData(path).toLowerCase());
        output.printWords(sortWords(text));
    }

    private HashMap<Character, Sentence> sortWords(Text text){
        HashMap<Character, Sentence> result = new HashMap<Character, Sentence>();
        for (Sentence sentence : text.getData()) {
            for (TextElement textElement : sentence.getData()) {
                if(textElement instanceof Word){
                    Word word = (Word) textElement;
                    if(!result.containsKey(word.getFirstLetter())){
                        Sentence wordsContainer = new Sentence();
                        wordsContainer.add(word);
                        result.put(word.getFirstLetter(), wordsContainer);
                    } else {
                        result.get(word.getFirstLetter()).add(word);
                    }
                }
            }
        }
        return result;
    }
}
