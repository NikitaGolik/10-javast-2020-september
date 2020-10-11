package by.golik.jwdcourse.task05.command;
import by.golik.jwdcourse.task05.invoker.TypeCommand;
import by.golik.jwdcourse.task05.reciever.Reciever;

public class CommandOne implements Command{
    Reciever reciever;

    public CommandOne(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        System.out.println();
        reciever.action(TypeCommand.ONE);
    }
}
