package by.golik.task08threads.state;

import by.golik.task08threads.trying.ElementIndex;

/**
 * @author Nikita Golik
 */
public abstract class State {
    ElementIndex elementIndex;

    State(ElementIndex elementIndex) {
        this.elementIndex = elementIndex;
    }
    public abstract String onLock();
    public abstract String onPlay();

}
