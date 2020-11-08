package by.golik.task08threads.service.state;


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
            element.changeState(new ReadyState(element));
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        return null;
    }

    @Override
    public String onReady() {
        return null;
    }
}
