package by.golik.task08threads.service.state;
import by.golik.task08threads.beans.Matrix;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class Element {

    private State state;
    private boolean busy = false;
    private List<Integer> listElements = new ArrayList<>();
    Matrix matrix;
    private int raw;
    private int col;
    int value;

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

    public void action() {

    }

    public Element() {
        this.state = new ReadyState(this);
        setBusy(true);
        for(int i = 0; i < matrix.getDiagonalSize(); i++) {
            listElements.add(i);
        }
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

}
