package by.golik.jwdcourse.task04.beans;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class Wrapper for Integer
 *
 */

public class Array {
    private int[] data;
    private int length;

    /**
     * Creates new Object
     * @param data - getting data
     * @param length - length of array
     */
    public Array(int[] data, int length) {
        this.data = data;
        this.length = length;
    }

    /**
     *
     * @return data
     */
    public int[] getData() {
        return data;
    }

    /**
     * Definition of data
     * @param data
     */
    public void setData(int[] data) {
        this.data = data;
    }

    /**
     *
     * @return
     */

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", length=" + length +
                '}';
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return length == array.length &&
                Arrays.equals(data, array.data);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(length);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
