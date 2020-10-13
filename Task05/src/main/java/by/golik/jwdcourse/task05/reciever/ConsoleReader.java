package by.golik.jwdcourse.task05.reciever;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class ConsoleReader {
    public String readerFromConsole(String s) throws IOException {
        List<String> input = new ArrayList();
        Scanner scan = new Scanner(System.in);
        while(true){
            String current = scan.nextLine();
            if(current.equals(""))break;
            input.add(current);
        }
        return s;
    }
}
