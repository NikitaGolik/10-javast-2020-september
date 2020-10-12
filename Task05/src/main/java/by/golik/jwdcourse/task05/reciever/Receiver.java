package by.golik.jwdcourse.task05.reciever;
import by.golik.jwdcourse.task05.command.TypeCommand;
import by.golik.jwdcourse.task05.view.PrintNewText;
import java.io.IOException;


public class Receiver {
    Service service = new Service();
    PrintNewText printNewText = new PrintNewText();
    ReaderFromFile readerFromFile = new ReaderFromFile();
    public void action(TypeCommand cmd) throws IOException {
        switch (cmd) {
            case ONE:
                service.replaceSymbol(readerFromFile.readStringFromFile(), 2, 's');
                System.out.println(service.replaceSymbol(readerFromFile.readStringFromFile(), 2, 's'));
                break;
            case TWO:
                service.replace(readerFromFile.readStringFromFile());
                System.out.println(service.replace(readerFromFile.readStringFromFile()));
                break;
            case THREE:
                service.replaceSubstring(readerFromFile.readStringFromFile());
                System.out.println(service.replaceSubstring(readerFromFile.readStringFromFile()));
                break;
            case FOUR:
                service.deleteSymbols(readerFromFile.readStringFromFile());
                System.out.println(service.deleteSymbols(readerFromFile.readStringFromFile()));
                break;
            case FIVE:
                service.remove(readerFromFile.readStringFromFile());
                System.out.println(service.remove(readerFromFile.readStringFromFile()));
                break;
        }
    }
}
