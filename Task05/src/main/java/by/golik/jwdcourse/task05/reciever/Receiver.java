package by.golik.jwdcourse.task05.reciever;
import by.golik.jwdcourse.task05.command.TypeCommand;
import java.io.IOException;

/**
 * A class that has information about how to perform operations on text
 */
public class Receiver {

    Service service = new Service();
    ServiceRegex serviceRegex = new ServiceRegex();
    ReaderFromFile readerFromFile = new ReaderFromFile();
    ConsoleReader consoleReader = new ConsoleReader();

    /**
     * This method executes the request sent by the command
     * @param cmd - number of command
     * @throws IOException
     */
    public void action(TypeCommand cmd) throws IOException {
        switch (cmd) {
            case ONE:
                service.replaceSymbol(consoleReader.readerFromConsole(), 2, '@');
                service.replaceSymbol(readerFromFile.readStringFromFile(), 1, '@');
                serviceRegex.replaceSymbolRegex(readerFromFile.readStringFromFile(), 3, 'a');
                serviceRegex.replaceSymbolRegex(readerFromFile.readStringFromFile(), 4, 'b');
                break;
            case TWO:
                service.replace(consoleReader.readerFromConsole());
                service.replace(readerFromFile.readStringFromFile());
                serviceRegex.replaceRegex(readerFromFile.readStringFromFile());
                serviceRegex.replaceRegex(readerFromFile.readStringFromFile());
                break;
            case THREE:
                service.replaceSubstring(consoleReader.readerFromConsole());
                service.replaceSubstring(readerFromFile.readStringFromFile());
                serviceRegex.replaceSubstringRegex((readerFromFile.readStringFromFile()));
                serviceRegex.replaceSubstringRegex(readerFromFile.readStringFromFile());
                break;
            case FOUR:
                service.deleteAllSymbols(consoleReader.readerFromConsole());
                service.deleteAllSymbols(readerFromFile.readStringFromFile());
                serviceRegex.deleteAllSymbolsRegex(readerFromFile.readStringFromFile());
                serviceRegex.deleteAllSymbolsRegex(readerFromFile.readStringFromFile());
                break;
            case FIVE:
                service.remove(consoleReader.readerFromConsole());
                service.remove(readerFromFile.readStringFromFile());
                serviceRegex.deleteWordsRegex(readerFromFile.readStringFromFile());
                serviceRegex.deleteWordsRegex(readerFromFile.readStringFromFile());
                break;
        }
    }
}
