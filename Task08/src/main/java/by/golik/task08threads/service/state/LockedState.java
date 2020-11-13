package by.golik.task08threads.service.state;


import by.golik.task08threads.beans.Element;

/**
 * @author Nikita Golik
 */
public class LockedState extends State {

    LockedState(Element element) {
        super(element);
        element.setBusy(false);
    }


    @Override
    public String onLock() {
        if (element.isBusy()) {
            element.changeState(new FreeState(element));
            return "Stop";
        } else {
            return "Locked...";
        }
    }
}
