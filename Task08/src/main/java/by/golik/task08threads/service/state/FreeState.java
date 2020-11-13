package by.golik.task08threads.service.state;


import by.golik.task08threads.beans.Element;

/**
 * @author Nikita Golik
 */
public class FreeState extends State {

    public FreeState(Element element) {
        super(element);
    }

    @Override
    public String onLock() {
        element.changeState(new LockedState(element));
        return "Locked...";
    }
}
