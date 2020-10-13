package by.golik.jwdcourse.task05.reciever;
import by.golik.jwdcourse.task05.command.TypeCommand;
import java.io.IOException;

/**
 *
 */
public class Receiver {
    Service service = new Service();
    ServiceRegex serviceRegex = new ServiceRegex();
    ReaderFromFile readerFromFile = new ReaderFromFile();

    /**
     *
     * @param cmd
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
//                service.deleteSymbols(readerFromFile.readStringFromFile());
                serviceRegex.deleteSymbolsRegex(readerFromFile.readStringFromFile());
                break;
            case FIVE:
//                service.remove(readerFromFile.readStringFromFile());
                serviceRegex.deleteWordsRegex(readerFromFile.readStringFromFile());
                break;
        }
    }
}
