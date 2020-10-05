import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            System.out.println("1 — белорусский /n 2 — английский \n любой — русский ");
            char j = 0;
            try {
                j = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String country = "";
            String language = "";
            switch (j) {
                case '1':
                    country = "BY";
                    language = "BE";
                    break;
                case '2':
                    country = "US";
                    language = "EN";
                    break;
            }
            Locale current = new Locale(language, country);
            ResourceBundle rb = ResourceBundle.getBundle("text", current);
            String s1 = rb.getString("message.str1");
            System.out.println(s1);
            String s2 = rb.getString("message.str2");
            System.out.println(s2);
        }
    }
}
