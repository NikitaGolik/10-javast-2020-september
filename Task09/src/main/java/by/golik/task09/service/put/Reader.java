package by.golik.task09.service.put;

import by.golik.task09.service.handler2.ParserText;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Nikita Golik
 */
public class Reader {

    private String fromFileName;

    public Reader(String fromFileName) {
        this.fromFileName = fromFileName;
    }

    public void readFromFile(String fromFileName) throws IOException
    {
        byte[] textEncoded = Files.readAllBytes(Paths.get(fromFileName));

        String content = new String(textEncoded);
    }
}
