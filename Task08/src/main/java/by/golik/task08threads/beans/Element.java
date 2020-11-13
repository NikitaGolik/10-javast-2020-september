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

    public Element() {

    }

    public Element(int raw, int col, int value) {
        this.raw = raw;
        this.col = col;
        this.value = value;
        this.state = new FreeState(this);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRaw() {
        return raw;
    }

    public int getCol() {
        return col;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void changeState(State state) {
        this.state = state;
    }
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
