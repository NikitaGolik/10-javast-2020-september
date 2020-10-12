package by.golik.jwdcourse.task05.command;

import by.golik.jwdcourse.task05.reciever.Receiver;

import java.io.IOException;

public class CommandFive implements Command {
    Receiver receiver;

    public CommandFive(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() throws IOException {
        System.out.println();
        receiver.action(TypeCommand.FIVE);
    }
}
