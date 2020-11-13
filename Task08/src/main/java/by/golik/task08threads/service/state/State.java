package by.golik.task08threads.service.state;


import by.golik.task08threads.beans.Element;

/**
 * @author Nikita Golik
 */
public abstract class State {
    Element element;

    State(Element element) {
        this.element = element;
    }

    public abstract String onLock();



}
