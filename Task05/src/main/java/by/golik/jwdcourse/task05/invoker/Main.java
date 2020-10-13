package by.golik.jwdcourse.task05.invoker;
import by.golik.jwdcourse.task05.client.Client;
import by.golik.jwdcourse.task05.command.Command;
import by.golik.jwdcourse.task05.command.TypeCommand;
import by.golik.jwdcourse.task05.reciever.Receiver;
import java.io.IOException;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         *
         */
        Receiver receiver = new Receiver();
        Client client = new Client(receiver);
/**
 *
 */
        Command commandOne = client.initCommand(TypeCommand.ONE);
        Invoker invokerOne = new Invoker(commandOne);
        invokerOne.invokeCommand();

//        Command commandTwo = client.initCommand(TypeCommand.TWO);
//        Invoker invokerTwo = new Invoker(commandTwo);
//        invokerTwo.invokeCommand();
//
//        Command commandThree = client.initCommand(TypeCommand.THREE);
//        Invoker invokerThree = new Invoker(commandThree);
//        invokerThree.invokeCommand();

//        Command commandFour = client.initCommand(TypeCommand.FOUR);
//        Invoker invokerFour = new Invoker(commandFour);
//        invokerFour.invokeCommand();
//
//        Command commandFive = client.initCommand(TypeCommand.FIVE);
//        Invoker invokerFive = new Invoker(commandFive);
//        invokerFive.invokeCommand();

    }
}
