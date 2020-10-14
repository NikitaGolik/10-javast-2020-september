package by.golik.jwdcourse.task05.command;
import by.golik.jwdcourse.task05.reciever.Receiver;
import java.io.IOException;

/**
 * A class defines a specific executor
 */
public class CommandOne implements Command{
    Receiver receiver;

    /**
     * defines a specific executor
     * @param receiver - a specific executor
     */
    public CommandOne(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * The method refers to the required business logic operation
     * @throws IOException if stream to file cannot be written to or closed.
     */
    @Override
    public void execute() throws IOException {
        System.out.println();
        receiver.action(TypeCommand.ONE);
    }
}
