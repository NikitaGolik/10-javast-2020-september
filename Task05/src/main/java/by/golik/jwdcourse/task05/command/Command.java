package by.golik.jwdcourse.task05.command;
import java.io.IOException;

/**
 * Defines an abstraction for handling command objects
 */
public interface Command {
    /**
     * Method-abstraction
     * @throws IOException if stream to file cannot be written to or closed.
     */
    void execute() throws IOException;
}
