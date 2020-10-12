package by.golik.jwdcourse.task05.invoker;
import by.golik.jwdcourse.task05.command.Command;

import java.io.IOException;

public class Invoker {
    private Command mCommand;

    public Invoker(Command mCommand) {
        this.mCommand = mCommand;
    }
    public void invokeCommand() throws IOException {
        System.out.println();
        mCommand.execute();
    }
}


