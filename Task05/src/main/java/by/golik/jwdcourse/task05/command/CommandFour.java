package by.golik.jwdcourse.task05.command;
import by.golik.jwdcourse.task05.invoker.TypeCommand;
import by.golik.jwdcourse.task05.reciever.Reciever;

public class CommandFour implements Command {
    Reciever reciever;

    public CommandFour(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        System.out.println();
        reciever.action(TypeCommand.FOUR);
    }
}
