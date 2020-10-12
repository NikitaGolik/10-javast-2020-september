package by.golik.jwdcourse.task05.reciever;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    public String readerFromConsole(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s = reader.readLine();
        return s;
    }
}
