package by.golik.entity;

/**
 * @author Nikita Golik
 */
public class Symbol implements Part {
    private String symbol;

    public Symbol(String word) {
        this.symbol = word;
    }
    @Override
    public void print() {
        System.out.print(this.symbol);
    }
}
