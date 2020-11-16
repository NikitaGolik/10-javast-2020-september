package by.golik.task09.entity;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Nikita Golik
 */
public interface TextElement {

    // метод должен возвращать список элементов текста (предложения, слова, абзацы и прочее)
    Iterable<? extends TextElement> getElement();

    // вывод текста куда угодно(консоль, файл, строка и т.п.),
    // все что можно наследовать от абстрактного класса "Writer")
    void printToWriter(Writer writer) throws IOException;
}
