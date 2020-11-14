package by.golik.task08threads.beans;

import by.golik.task08threads.service.state.FreeState;
import by.golik.task08threads.service.state.State;

/**
 * @author Nikita Golik
 */
public class Element {

    private State state;
    private boolean busy = false;
    private int raw;
    private int col;
    int value;

    public Element(int value) {
        this.value = value;
    }

    /**
     * Element of Matrix
     * @param raw - number of raw in matrix
     * @param col - number of coloumns in matrix
     * @param value - value of element
     */
    public Element(int raw, int col, int value) {
        this.raw = raw;
        this.col = col;
        this.value = value;
        this.state = new FreeState(this);
    }

    /**
     * getter for value
     * @return int value
     */
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * getter for raw
     * @return int raw
     */
    public int getRaw() {
        return raw;
    }

    public int getCol() {
        return col;
    }

    /**
     * status of element
     * @return boolean value
     */
    public boolean isBusy() {
        return busy;
    }

    /**
     *  status of element
     * @param busy - boolean value
     */
    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    /**
     * change status of element
     * @param state - status of element
     */
    public void changeState(State state) {
        this.state = state;
    }

    /**
     * get status of element
     * @return status of element
     */
    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Element{" +
                ", raw=" + raw +
                ", col=" + col +
                ", value=" + value +
                '}';
    }
}
