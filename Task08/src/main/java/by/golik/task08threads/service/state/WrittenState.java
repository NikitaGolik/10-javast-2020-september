package by.golik.task08threads.service.state;


import by.golik.task08threads.beans.Element;

/**
 * @author Nikita Golik
 */
public class WrittenState extends State {

    WrittenState(Element element) {
        super(element);
    }

    @Override
    public String onLock() {
        element.changeState(new LockedState(element));
        return "Lock";
    }
}
