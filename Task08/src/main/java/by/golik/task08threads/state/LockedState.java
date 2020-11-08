package by.golik.task08threads.state;

import by.golik.task08threads.trying.ElementIndex;

/**
 * @author Nikita Golik
 */
public class LockedState extends State {

    LockedState(ElementIndex elementIndex) {
        super(elementIndex);
        elementIndex.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (elementIndex.isPlaying()) {
            elementIndex.changeState(new ReadyState(elementIndex));
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        elementIndex.changeState(new ReadyState(elementIndex));
        return "Ready";
    }

}
