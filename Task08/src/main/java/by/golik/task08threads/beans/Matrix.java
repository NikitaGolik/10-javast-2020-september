package by.golik.task08threads.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Nikita Golik
 */
public class Matrix {
    private int[][] matrix;


    public Matrix(int raw, int col) throws Exception {
        if((raw < 1) || (col < 1)) {
            throw new Exception();
        }
        this.matrix = new int[raw][col];
    }

    private void checkRange(int x, int y) {
        if (x >= this.matrix.length || y >= this.matrix[x].length) {
            throw new IndexOutOfBoundsException("вы вывалились за пределы массива");
        }
    }
    // получить элемент матрицы в x- строке , в y-столбце
    public int get(int x, int y) {
        checkRange(x, y);
        return this.matrix[x][y];
    }


    public void put(int x, int y, int value) {
        checkRange(x, y);
        this.matrix[x][y] = value;
    }
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
            int adress = 0;
            for (int i = 0; i < matrix.getVerticalSize(); i++) {
                for(int j = 0; j < matrix.getHorizontalSize(); j++) {
                    integers.add(matrix.get(i,j));
                }
            }
            return integers;
    }

    /**
     * Constructor that creates an object
     * @param array array of elements
     */


    /**
     * Constructor that creates an object with param
     * @param raw - count of raws
     * @param col - count of colouns
     * @throws Exception
     */


    /**
     * getter for vertical size(raws)
     * @return length of array
     */


    /**
     * getter for horizontal size(col)
     * @return length of array
     */


    /**
     * getter for element
     * @param i - index of element in 1st array
     * @param j - index of element in 2nd array
     * @return value of element
     * @throws Exception
     */


    /**
     * setter for element
     * @param i - index of element in 1st array
     * @param j - index of element in 2nd array
     * @param value of element
     * @throws Exception
     */


    /**
     * checking valid array
     * @param i - index
     * @param j - index
     * @return true or false
     */


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
