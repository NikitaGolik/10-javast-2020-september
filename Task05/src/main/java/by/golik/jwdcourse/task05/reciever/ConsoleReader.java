package by.golik.jwdcourse.task05.reciever;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class includes method which get text from user console
 */
public class ConsoleReader {
    /**
     *
     * @param text - entered text by user
     * @return text for next correction
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public String readerFromConsole(String text) throws IOException {
        List<String> input = new ArrayList();
        Scanner scan = new Scanner(System.in);
        while(true){
            String current = scan.nextLine();
            if(current.equals(""))break;
            input.add(current);
        }
        return text;
    }
}
