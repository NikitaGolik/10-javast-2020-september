package by.golik.task08threads.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Nikita Golik
 */
public class Matrix {
    private final int[][] matrix;

    /**
     * Constructor that creates an object with param
     * @param raw - count of raws
     * @param col - count of colouns
     */
    public Matrix(int raw, int col) throws Exception {
        if((raw < 1) || (col < 1)) {
            throw new Exception();
        }
        this.matrix = new int[raw][col];
    }

    private void checkRange(int i, int j) {
        if (i >= this.matrix.length || j >= this.matrix[i].length) {
            throw new IndexOutOfBoundsException("вы вышли за пределы массива");
        }
    }
    /**
     * getter for element
     * @param i - index of element in 1st array
     * @param j - index of element in 2nd array
     * @return value of element
     */
    public int get(int i, int j) {
        checkRange(i, j);
        return this.matrix[i][j];
    }

    /**
     * setter for element
     * @param i - index of element in 1st array
     * @param j - index of element in 2nd array
     * @param value of element
     */
    public void put(int i, int j, int value) {
        checkRange(i, j);
        this.matrix[i][j] = value;
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

    public List<Integer> convert(Matrix matrix) {
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < matrix.getVerticalSize(); i++) {
                for(int j = 0; j < matrix.getHorizontalSize(); j++) {
                    integers.add(matrix.get(i,j));
                }
            }
            return integers;
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
