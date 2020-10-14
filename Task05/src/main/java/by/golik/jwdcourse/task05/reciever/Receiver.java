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

    /**+
     * This method executes the request sent by the command
     * @param cmd - number of command
     * @throws IOException
     */
    public void action(TypeCommand cmd) throws IOException {
        switch (cmd) {
            case ONE:
//                service.replaceSymbol(readerFromFile.readStringFromFile(), 1, '@');
                serviceRegex.replaceSymbolRegex(readerFromFile.readStringFromFile(), 3, 'a');
                break;
            case TWO:
//                service.replace(readerFromFile.readStringFromFile());
                serviceRegex.replaceRegex(readerFromFile.readStringFromFile());
                break;
            case THREE:
//                service.replaceSubstring(readerFromFile.readStringFromFile());
                serviceRegex.replaceSubstringRegex((readerFromFile.readStringFromFile()));
                break;
            case FOUR:
//                service.deleteAllSymbols(readerFromFile.readStringFromFile());
                serviceRegex.deleteAllSymbolsRegex(readerFromFile.readStringFromFile());
                break;
            case FIVE:
                service.remove(readerFromFile.readStringFromFile());
//                serviceRegex.deleteWordsRegex(readerFromFile.readStringFromFile());
                break;
        }
    }
}
