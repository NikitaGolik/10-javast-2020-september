package by.golik.jwdcourse.task05.client;
import by.golik.jwdcourse.task05.command.*;
import by.golik.jwdcourse.task05.reciever.Receiver;

/**
 *
 */
public class Client {
    private Receiver mReceiver;

    /**
     *
     * @param Receiver
     */
    public Client(Receiver Receiver) {
        mReceiver = Receiver;
    }

    /**
     *
     * @param cmd
     * @return
     */
    public Command initCommand(TypeCommand cmd) {
        Command command = null;
        switch (cmd) {
            case ONE:
                System.out.println("Creating command One & set up it's receiver");
                command = new CommandOne(mReceiver);
                break;
            case TWO:
                System.out.println("Creating command Two & set up it's receiver");
                command = new CommandTwo(mReceiver);
                break;
            case THREE:
                System.out.println("Creating command Three & set up it's receiver");
                command = new CommandThree(mReceiver);
                break;
            case FOUR:
                System.out.println("Creating command Four & set up it's receiver");
                command = new CommandFour(mReceiver);
                break;
            case FIVE:
                System.out.println("Creating command Five & set up it's receiver");
                command = new CommandFive(mReceiver);
                break;
        }
        return command;
    }
}
