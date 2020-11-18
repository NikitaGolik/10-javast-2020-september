package by.golik.task09.entity;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class Sentence extends CompositeTextElement {
    // конструктор
    public Sentence(List<WordOrPunctuation> elementList) {
        super(elementList);
    }

}
