package by.golik.task08threads.beans;

import java.util.List;

/**
 * @author Nikita Golik
 */
public class MatrixAsList {

    private final List<Element> matrixTable;

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


    @Override
    public String toString() {
        return "MatrixAsList{" +
                "matrixTable=" + matrixTable +
                '}';
    }
}
