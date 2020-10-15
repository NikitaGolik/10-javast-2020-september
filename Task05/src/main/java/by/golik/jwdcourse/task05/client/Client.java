package by.golik.jwdcourse.task05.client;
import by.golik.jwdcourse.task05.command.*;
import by.golik.jwdcourse.task05.reciever.Receiver;

/**
 * Сlass for defining the command type and initializing the appropriate object
 */
public class Client {
    private Receiver mReceiver;

    /**
     * Constructor that creates a specific executor
     * @param Receiver - specific executor
     */
    public Client(Receiver Receiver) {
        mReceiver = Receiver;
    }

    /**
     * initialization of a suitable command
     * @param cmd - definite command
     * @return - specific command
     */
    public Command initCommand(TypeCommand cmd) {
        Command command = null;
        switch (cmd) {
            case ONE:
                System.out.println("1 - в каждом слове k-ю букву заменить заданным символом ");
                System.out.println("Creating command One & set up it's receiver");
                command = new CommandOne(mReceiver);
                break;
            case TWO:
                System.out.println("Creating command Two & set up it's receiver");
                System.out.println("2 - В тексте после буквы, Р, если она не последняя в слове, ошибочно напечатана буква А, вместо О.");
                command = new CommandTwo(mReceiver);
                break;
            case THREE:
                System.out.println("Creating command Three & set up it's receiver");
                System.out.println("3 - В тексте слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова");
                command = new CommandThree(mReceiver);
                break;
            case FOUR:
                System.out.println("Creating command Four & set up it's receiver");
                System.out.println("4 - Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами (и рус и англ). ");
                command = new CommandFour(mReceiver);
                break;
            case FIVE:
                System.out.println("Creating command Five & set up it's receiver");
                System.out.println("5 - Из текста удалить все слова заданной длины, начинающиеся на согласную букву.");
                command = new CommandFive(mReceiver);
                break;
        }
        return command;
    }
}
