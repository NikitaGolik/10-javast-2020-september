package by.golik.jwdcourse.task04.beans;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class Wrapper for Integer
 *
 */

public class Array {
    private int[] data;

    /**
     * Creates new Object
     * @param data - getting data
     *
     */
    public Array(int[] data, int length) {
        this.data = new int[length];
    }

    public Array(int length) throws Exception {
        if(length < 1) {
            throw new Exception();
        }
        this.data = new int[length];
    }

    /**
     *
     * @return data
     */


    public int getLength() {
        return data.length;
    }


    public int getElement(int i) {
        return data[i];
    }
    public void setElement(int i, int value) {
        data[i] = value;
    }
    /**
     * Definition of data
     *
     */

/**
 *
 * @return
 */


    /**
     * This method returns a string representation of the object
     * @return
     */
    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    /**
     * Method indicates whether some other object is "equal to" this one.
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Arrays.equals(data, array.data);
    }

    /**
     * Method returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     * @return
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}