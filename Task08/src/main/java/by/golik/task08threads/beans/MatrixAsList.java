package by.golik.task08threads.beans;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class MatrixAsList {

    private List<Element> matrixTable;

    public MatrixAsList(List<Element> matrixTable) {
        this.matrixTable = matrixTable;
    }

    public void setMatrixTable(List<Element> matrixTable) {
        this.matrixTable = matrixTable;
    }
    public int getMatrixCapacity (){
        return matrixTable.size();
    }

    public Element getElement(int i) {
        return matrixTable.get(i);
    }
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
