package by.golik.jwdcourse.task05.command;
import by.golik.jwdcourse.task05.reciever.Receiver;
import java.io.IOException;

/**
 * A class defines a specific executor
 */
public class CommandFour implements Command {
    Receiver receiver;

    /**
     * Defines a specific executor
     * @param receiver - a specific executor
     */
    public CommandFour(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     *
     * @throws IOException if stream to file cannot be written to or closed.
     */
    @Override
    public void execute() throws IOException {
        System.out.println();
        receiver.action(TypeCommand.FOUR);
    }
}
