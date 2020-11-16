package by.golik.task08threads.service.state;


import by.golik.task08threads.beans.Element;

/**
 * @author Nikita Golik
 */
public class FreeState implements State {

    @Override
    public void onLock(Element element) {
        element.changeState(new LockedState());
    }


}
