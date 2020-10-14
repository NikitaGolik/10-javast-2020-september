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
     * This method gets text from user
     * @return text for next correction
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public String readerFromConsole() throws IOException {
        List<String> input = new ArrayList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст, для прекращения ввода текста, нажмите Enter 2 раза");
        while(true){
            String current = scan.nextLine();
            if(current.equals(""))break;
            input.add(current);
        }
        return input.toString();
    }
}
