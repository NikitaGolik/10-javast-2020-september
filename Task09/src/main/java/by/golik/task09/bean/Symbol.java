package by.golik.task09.bean;

import by.golik.task09.service.exception.*;

/**
 * this class describes the lower level element
 * @author Nikita Golik
 */
public class Symbol implements TextElement {

    private static final int ONE_SYMBOL = 1;

    private String symbol;
    private TextElementType textElementType;

    /**
     *
     * @param symbol - that has only one char element
     * @param textElementType - element of text type
     * @throws IncorrectInputParametersException - element must have only one char element
     */
    public Symbol(String symbol, TextElementType textElementType) throws IncorrectInputParametersException {
        if(symbol.length() == ONE_SYMBOL) {
            this.symbol = symbol;
            this.textElementType = textElementType;
        }
        else {
            throw new IncorrectInputParametersException("This is not a symbol");
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
