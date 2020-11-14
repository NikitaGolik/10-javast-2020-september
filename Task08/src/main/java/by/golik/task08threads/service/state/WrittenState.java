package by.golik.task08threads.service.state;


import by.golik.task08threads.beans.Element;

/**
 * @author Nikita Golik
 */
public class WrittenState extends State {

    public WrittenState(Element element) {
        super(element);
    }

    @Override
    public void onLock(Element element) {

    }
}
