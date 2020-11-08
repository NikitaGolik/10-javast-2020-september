package by.golik.task08threads.state;

import by.golik.task08threads.trying.ElementIndex;

/**
 * @author Nikita Golik
 */
public class ReadyState extends State {
    public ReadyState(ElementIndex elementIndex) {
        super(elementIndex);
    }

    @Override
    public String onLock() {
        elementIndex.changeState(new LockedState(elementIndex));
        return "Locked...";
    }

    @Override
    public String onPlay() {
        String action = elementIndex.startPlayback();
        elementIndex.changeState(new PlayingState(elementIndex));
        return action;
    }
}
