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
    public void onLock(Element element) {
        if (element.isBusy()) {
            element.changeState(new WrittenState(element));

        } else {
            element.setBusy(true);
        }
    }

}
