package by.golik.task08threads.beans;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class MatrixAsList {

    private List<Element> matrixTable;

    /**
     * list that has all elements of matrix
     * @param matrixTable - table of elements
     */
    public MatrixAsList(List<Element> matrixTable) {
        this.matrixTable = matrixTable;
    }

    public List<Element> getMatrixTable() {
        return matrixTable;
    }

    public void setMatrixTable(List<Element> matrixTable) {
        this.matrixTable = matrixTable;
    }

    public Element getElement(int i) {
        return matrixTable.get(i);
    }

    /**
     * add element to list
     * @param element - element of matrix
     */
    public void addElement(Element element) {
        matrixTable.add(element);
    }

    public void setElement(int index, Element element) {
        matrixTable.set(index, element);
    }

    @Override
    public String toString() {
        return "MatrixAsList{" +
                "matrixTable=" + matrixTable +
                '}';
    }
}
