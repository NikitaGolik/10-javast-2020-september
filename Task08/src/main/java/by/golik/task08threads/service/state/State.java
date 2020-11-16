package by.golik.task08threads.service.state;


import by.golik.task08threads.beans.Element;

/**
 * @author Nikita Golik
 */
public interface State {

    public void onLock(Element element);

}
