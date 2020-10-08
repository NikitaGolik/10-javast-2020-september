package by.golik.jwdcourse.task04.beans;

import java.util.Arrays;

/**
 * Class Wrapper for Jagged Arrays
 * @author Nikita Golik
 */

public class JaggedArray {
    private int[][] array;
    private int raw;
    private int col;

    public JaggedArray(int[][] array, int raw, int col) {
        this.raw = raw;
        this.col = col;
        this.array = new int[raw][col];
    }

    public JaggedArray(int[][] array) {
        this.array = array;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "JaggedArray{" +
                "data=" + Arrays.toString(array) +
                '}';
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
