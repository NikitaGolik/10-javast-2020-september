package by.golik.jwdcourse.task05.command;
import by.golik.jwdcourse.task05.reciever.Receiver;

import java.io.IOException;

public class CommandTwo implements Command {
    Receiver receiver;

    public CommandTwo(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() throws IOException {
        System.out.println();
        receiver.action(TypeCommand.TWO);
    }
}
