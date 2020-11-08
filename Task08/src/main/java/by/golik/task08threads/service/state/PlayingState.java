package by.golik.task08threads.service.state;


/**
 * @author Nikita Golik
 */
public class PlayingState extends State {

    PlayingState(Element element) {
        super(element);
    }

    @Override
    public String onLock() {
        element.changeState(new LockedState(element));
        return "Lock";
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
