package by.golik.task09.entity;

import java.util.Objects;

/**
 * @author Nikita Golik
 */
public class Symbol {
    private char data;

    /**
     * constructor
     * @param data - data by symbol
     */
    public Symbol(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return data == symbol.data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + data;
        return result;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
