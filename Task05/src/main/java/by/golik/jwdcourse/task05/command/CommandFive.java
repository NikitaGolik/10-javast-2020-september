package by.golik.jwdcourse.task05.command;

import by.golik.jwdcourse.task05.reciever.Reciever;

public class CommandFive implements Command {
    Reciever reciever;

    public CommandFive(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        System.out.println();
        reciever.action(TypeCommand.FIVE);
    }
}
