package by.golik.jwdcourse.task05.reciever;

import by.golik.jwdcourse.task05.bean.Document;
import by.golik.jwdcourse.task05.invoker.TypeCommand;

public class Reciever {
    private Document document;
    public void action(TypeCommand cmd) {
        switch (cmd) {
            case ONE:
                break;
            case TWO:
                break;
            case THREE:
                break;
            case FOUR:
                break;
        }
    }
}
