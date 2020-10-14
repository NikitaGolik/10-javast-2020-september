package by.golik.jwdcourse.task05.invoker;
import by.golik.jwdcourse.task05.command.Command;
import java.io.IOException;

/**
 * Class includes command executing method invocation class
 */
public class Invoker {

    private Command mCommand;
    /**
     * Constructor that creates definite command
     * @param mCommand - definite command
     */
    public Invoker(Command mCommand) {
        this.mCommand = mCommand;
    }

    /**
     * This method calls a command to execute
     * @throws IOException
     */
    public void invokeCommand() throws IOException {
        System.out.println();
        mCommand.execute();
    }
}


