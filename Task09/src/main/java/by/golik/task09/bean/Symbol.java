package by.golik.task09.bean;


import by.golik.task09.service.exception.*;

public class Symbol implements TextElement {

    private static final int ONE_SYMBOL = 1;

    private String symbol;
    private TextElementType textElementType;

    public Symbol(String symbol, TextElementType textElementType) throws IncorrectInputParametersException {
        if(symbol.length() == ONE_SYMBOL) {
            this.symbol = symbol;
            this.textElementType = textElementType;
        }
        else {
            throw new IncorrectInputParametersException("A symbol can not contain more than one character");
        }
    }

    @Override
    public TextElementType getElementType() {
        return textElementType;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
