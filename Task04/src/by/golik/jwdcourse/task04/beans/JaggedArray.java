package by.golik.jwdcourse.task04.beans;

import java.util.Arrays;

/**
 * Class Wrapper for Jagged Arrays
 * @author Nikita Golik
 */

public class JaggedArray {
    int[][] data;

    public JaggedArray(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JaggedArray{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggedArray that = (JaggedArray) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
