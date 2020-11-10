package by.golik.task09.entity;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Nikita Golik
 */
public abstract class TextElement {
    private List<Symbol> data;

    /**
     * constructor
     */
    public TextElement() {
        data = new LinkedList<>();
    }
    public TextElement(String s) {
        data = new LinkedList<Symbol>();
        for(char c : s.toCharArray()) {
            data.add(new Symbol(c));
        }
    }

    /**
     * method to add symbol to the text
     * @param symbol - symbol of text
     */
    public void add(Symbol symbol) {
        data.add(symbol);
    }

    public List<Symbol> getData() {
        return data;
    }

    public void setData(List<Symbol> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextElement that = (TextElement) o;
        if (data == null) {
            return that.data == null;
        } else return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        final  int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Symbol symbol : data) {
            sb.append(symbol.toString());
        }
        return sb.toString();
    }
}
