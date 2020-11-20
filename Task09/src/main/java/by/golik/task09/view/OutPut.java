package by.golik.task09.view;

import by.golik.task09.entity.Sentence;

import java.util.HashMap;

/**
 * @author Nikita Golik
 */
public class OutPut {

    public void printString(String str){
        System.out.println(str);
    }

    public void printWords(HashMap<Character, Sentence> container){
        for (Sentence sentence : container.values()) {
            System.out.println(sentence);
        }
    }
}
