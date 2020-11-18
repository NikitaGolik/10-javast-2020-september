package by.golik.task09.entity;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Nikita Golik
 */
public interface TextElement {

    // метод должен возвращать список элементов текста (предложения, слова, абзацы и прочее)
    Iterable<? extends TextElement> getElement();

    // вывод текста консоль, файл

    void printToWriter(Writer writer) throws IOException;
}
