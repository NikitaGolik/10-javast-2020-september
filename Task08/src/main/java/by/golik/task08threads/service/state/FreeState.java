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
    public void onLock(Element element) {
        element.changeState(new LockedState(element));
    }


}
