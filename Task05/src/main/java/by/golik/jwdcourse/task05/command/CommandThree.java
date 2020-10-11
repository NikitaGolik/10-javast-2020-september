package by.golik.jwdcourse.task05.command;
import by.golik.jwdcourse.task05.invoker.TypeCommand;
import by.golik.jwdcourse.task05.reciever.Reciever;

public class CommandThree implements Command {
    Reciever reciever;

    public CommandThree(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        System.out.println();
        reciever.action(TypeCommand.THREE);
    }
}
