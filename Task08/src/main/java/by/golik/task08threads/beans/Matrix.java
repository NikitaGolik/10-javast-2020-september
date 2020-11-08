package by.golik.task08threads.beans;
import java.util.Arrays;

/**
 * @author Nikita Golik
 */
public class Matrix {
    private int[][] matrix;

    /**
     * Constructor that creates an object
     * @param array array of elements
     */
    public Matrix(int[][] array) {
        this.matrix = array;
    }

    /**
     * Constructor that creates an object with param
     * @param raw - count of raws
     * @param col - count of colouns
     * @throws Exception
     */
    public Matrix(int raw, int col) throws Exception {
        if((raw < 1) || (col < 1)) {
            throw new Exception();
        }
        this.matrix = new int[raw][col];
    }

    public Matrix() {

    }
    public int getDiagonalSize() {
        return matrix.length;
    }

    /**
     * getter for vertical size(raws)
     * @return length of array
     */
    public int getVerticalSize() {
        return matrix.length;
    }

    /**
     * getter for horizontal size(col)
     * @return length of array
     */
    public int getHorizontalSize() {
        return matrix[0].length;
    }

    /**
     * getter for element
     * @param i - index of element in 1st array
     * @param j - index of element in 2nd array
     * @return value of element
     * @throws Exception
     */
    public int getElement(int i, int j) throws Exception {
        if (checkRange(i, j)) {
            return matrix[i][j];
        }
        throw new Exception();
    }

    /**
     * setter for element
     * @param i - index of element in 1st array
     * @param j - index of element in 2nd array
     * @param value of element
     * @throws Exception
     */
    public void setElement(int i, int j, int value) throws Exception {
            matrix[i][j] = value;
    }
    public void setDiagonalElement(int number) {
        for (int i = 0; i < getVerticalSize(); i++) {
            for (int j = 0; j < getHorizontalSize(); j++) {
                if (i == j) {
                    matrix[i][j] = number;
                }
            }
        }
    }

    /**
     * checking valid array
     * @param i - index
     * @param j - index
     * @return true or false
     */
    private boolean checkRange(int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method returns a string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nmatrix : " + matrix.length + "x" + matrix[0].length + "\n");
        for (int[] row : matrix) {
            for(int value : row) {
                sb.append(value + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * equals (for compare)
     * @param o object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix that = (Matrix) o;
        return Arrays.equals(matrix, that.matrix);
    }

    /**
     * Method returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }
}
