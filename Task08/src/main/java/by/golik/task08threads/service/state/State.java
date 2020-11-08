package by.golik.task08threads.service.state;


/**
 * @author Nikita Golik
 */
public abstract class State {
    Element element;

    State(Element element) {
        this.element = element;
    }
    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onReady();


}
