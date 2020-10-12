package by.golik.jwdcourse.task05.client;
import by.golik.jwdcourse.task05.command.*;
import by.golik.jwdcourse.task05.reciever.Receiver;

public class Client {
    private Receiver mReceiver;

    public Client(Receiver Receiver) {
        mReceiver = Receiver;
    }
    public Command initCommand(TypeCommand cmd) {
        Command command = null;
        switch (cmd) {
            case ONE:
                command = new CommandOne(mReceiver);
                break;
            case TWO:
                command = new CommandTwo(mReceiver);
                break;
            case THREE:
                command = new CommandThree(mReceiver);
                break;
            case FOUR:
                command = new CommandFour(mReceiver);
                break;
            case FIVE:
                command = new CommandFive(mReceiver);
                break;
        }
        return command;
    }
}
