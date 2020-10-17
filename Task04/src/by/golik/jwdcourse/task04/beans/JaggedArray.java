package by.golik.jwdcourse.task04.beans;

import java.util.Arrays;

/**
 * Class Wrapper for Jagged Arrays
 * @author Nikita Golik
 */

public class JaggedArray {
    private int[][] array;

    public JaggedArray(int[][] array) {
        this.array = array;
    }

    public JaggedArray(int raw, int col) throws Exception {
        if((raw < 1) || (col < 1)) {
            throw new Exception();
        }
        this.array = new int[raw][col];
    }


    public int getVerticalSize() {
        return array.length;
    }
    public int getHorizontalSize() {
        return array[0].length;
    }

    public int getElement(int i, int j) throws Exception {
        if (checkRange(i, j)) {
            return array[i][j];
        }
        throw new Exception();
    }
    public void setElement(int i, int j, int value) throws Exception {
        if (checkRange(i, j)) {
            array[i][j] = value;
        } throw new Exception();
    }

    private boolean checkRange(int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array[0].length) {
            return true;
        } else {
            return false;
        }
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggedArray that = (JaggedArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
