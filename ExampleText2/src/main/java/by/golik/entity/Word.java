package by.golik.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class Word implements Part {

    private List<Part> childPrintable = new ArrayList<Part>();

    public void add(Part printable) {
        childPrintable.add(printable);
    }

    public void remove(Part printable) {
        childPrintable.remove(printable);
    }

    @Override
    public void print() {
        for (Part printable : childPrintable) {
            printable.print();
        }
    }
}
