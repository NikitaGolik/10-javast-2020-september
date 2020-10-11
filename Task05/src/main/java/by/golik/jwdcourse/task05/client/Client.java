package by.golik.jwdcourse.task05.client;
import by.golik.jwdcourse.task05.command.Command;
import by.golik.jwdcourse.task05.invoker.TypeCommand;
import by.golik.jwdcourse.task05.reciever.Reciever;

public class Client {
    private Reciever cReciever;

    public Client(Reciever Reciever) {
        cReciever = Reciever;
    }
    public Command initCommand(TypeCommand cmd) {
        Command command = null;
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
        return command;
    }
}
