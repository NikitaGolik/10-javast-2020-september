package by.golik.jwdcourse.task05.command;
import by.golik.jwdcourse.task05.reciever.Receiver;

import java.io.IOException;

/**
 *
 */
public class CommandFour implements Command {
    Receiver receiver;

    /**
     *
     * @param receiver
     */
    public CommandFour(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        System.out.println();
        receiver.action(TypeCommand.FOUR);
    }
}
