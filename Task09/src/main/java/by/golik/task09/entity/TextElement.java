package by.golik.task09.entity;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Nikita Golik
 */
public interface TextElement {

    // метод должен возвращать список элементов текста (предложения, слова, абзацы и прочее)
    void add (TextElement component);
    void remove (TextElement component);
    TextElement get (int i);
    int getSize();
    String compile ();

    // вывод текста консоль, файл

    void printToWriter(Writer writer) throws IOException;
}
