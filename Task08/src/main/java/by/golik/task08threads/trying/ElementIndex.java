package by.golik.task08threads.trying;

import by.golik.task08threads.state.ReadyState;
import by.golik.task08threads.state.State;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class ElementIndex {
    private State state;
    private boolean playing = false;
    private List<String> playList = new ArrayList<>();
    private int currentTrack = 0;

    public ElementIndex() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for(int i = 0; i < 12; i++) {
            playList.add("Track" + i);
        }
    }
    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlayback() {
        return "Playing " + playList.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playList.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playList.size() - 1;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }



    int row;
    int column;

    public ElementIndex(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
