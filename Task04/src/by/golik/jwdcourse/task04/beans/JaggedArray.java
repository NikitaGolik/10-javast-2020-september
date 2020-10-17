package by.golik.jwdcourse.task04.beans;
import java.util.Arrays;

/**
 * Class Wrapper for Jagged Arrays
 * @author Nikita Golik
 */

public class JaggedArray {
    private int[][] array;

    /**
     * Constructor that creates an object
     * @param array array of elements
     */
    public JaggedArray(int[][] array) {
        this.array = array;
    }

    /**
     * Constructor that creates an object with param
     * @param raw - count of raws
     * @param col - count of colouns
     * @throws Exception
     */
    public JaggedArray(int raw, int col) throws Exception {
        if((raw < 1) || (col < 1)) {
            throw new Exception();
        }
        this.array = new int[raw][col];
    }

    /**
     * getter for vertical size(raws)
     * @return length of array
     */
    public int getVerticalSize() {
        return array.length;
    }

    /**
     * getter for horizontal size(col)
     * @return length of array
     */
    public int getHorizontalSize() {
        return array[0].length;
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
            return array[i][j];
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
        if (checkRange(i, j)) {
            array[i][j] = value;
        } throw new Exception();
    }

    /**
     * checking valid array
     * @param i - index
     * @param j - index
     * @return true or false
     */
    private boolean checkRange(int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array[0].length) {
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
        StringBuilder sb = new StringBuilder("\nJaggedArray : " + array.length + "x" + array[0].length + "\n");
        for (int[] row : array) {
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
        JaggedArray that = (JaggedArray) o;
        return Arrays.equals(array, that.array);
    }

    /**
     * Method returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
