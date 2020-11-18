package by.golik.task09.entity;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author Nikita Golik
 */
public class Symbol implements TextElement{

    private char symbol;


    public Symbol(char symbol) {
        this.symbol = symbol;
    }


    @Override
    public Iterable<? extends TextElement> getElement() {
        return new ArrayList<>();
    }

    @Override
    public void printToWriter(Writer writer) throws IOException {
        writer.append(symbol);
    }


    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
