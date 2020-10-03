package by.golik.jwdcourse.task04;
import by.golik.jwdcourse.task04.view.FileReader;
import by.golik.jwdcourse.task04.view.impl.Reader;
import java.io.FileNotFoundException;

/**
 * @author Nikita
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
     Reader reader = new FileReader();
     reader.getReader();

    }
}
