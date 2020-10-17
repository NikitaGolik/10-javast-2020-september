package by.golik.jwdcourse.task04.beans;
import java.util.Arrays;

/**
 * Class Wrapper for Integer
 * @author Nikita Golik
 */

public class Array {
    private int[] data;

    /**
     *
     * @param data - array of integer numbers
     * @param length - size of array
     */
    public Array(int[] data, int length) {
        this.data = new int[length];
    }

    /**
     * constructor, that creates an object type Array
     * @param length - size of array
     * @throws Exception
     */
    public Array(int length) throws Exception {
        if(length < 1) {
            throw new Exception();
        }
        this.data = new int[length];
    }

    /**
     * getter for length
     * @return length of array
     */
    public int getLength() {
        return data.length;
    }

    /**
     * getter for element
     * @param i - index of element in array
     * @return value of element with index i
     */
    public int getElement(int i) {
        return data[i];
    }

    /**
     * setter for element
     * @param i - index of element in array
     * @param value of element in array
     */
    public void setElement(int i, int value) {
        data[i] = value;
    }

    /**
     * This method returns a string representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                '}';
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
        Array array = (Array) o;
        return Arrays.equals(data, array.data);
    }

    /**
     * Method returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}