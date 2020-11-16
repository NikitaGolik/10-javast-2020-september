package by.golik.task09.entity;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class Paragraph extends CompositeTextElement {

    public Paragraph(List<Sentence> sentenceList) {
        super(sentenceList);
    }

}
