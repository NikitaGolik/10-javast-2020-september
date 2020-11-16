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

    // общий метод, который меняет местами элементы текста в предложении по заданным индексам
    public void swapSentenceTextElementByIndex(int byIndex, int toIndex) {
        List<WordOrPunctuation> lst = (List<WordOrPunctuation>) getElementList();

        if (lst.size() > 1
                && (byIndex > 0 && toIndex > 0)
                && (byIndex < toIndex)) {
            WordOrPunctuation byElement = lst.get(byIndex);
            WordOrPunctuation toElement = lst.get(toIndex);

            lst.set(byIndex, toElement);
            lst.set(toIndex, byElement);
        }
    }
}
