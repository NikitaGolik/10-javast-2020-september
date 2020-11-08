package by.golik.task08threads.state;

import by.golik.task08threads.trying.ElementIndex;

/**
 * @author Nikita Golik
 */
public class PlayingState extends State {
    PlayingState(ElementIndex elementIndex) {
        super(elementIndex);
    }

    @Override
    public String onLock() {
        elementIndex.changeState(new LockedState(elementIndex));
        elementIndex.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        elementIndex.changeState(new ReadyState(elementIndex));
        return "Paused...";
    }
}
