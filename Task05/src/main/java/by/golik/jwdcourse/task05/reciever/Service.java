package by.golik.jwdcourse.task05.reciever;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

    /**+
     *
     * @param text
     * @throws IOException
     */
    public void fileWriter(String text) throws IOException {
        BufferedWriter output = null;
        try {
            File file = new File("D:\\demo\\newText.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
            }
        }
    }

    /**
     * 1.	В каждом слове k-ю букву заменить заданным символом.
     * Если k больше длины слова, корректировку не выполнять.
//     * @param offer
//     * @param index
//     * @param symbol
     * @return
     */

    public String replaceSymbol(String text, int index, char symbol) throws IOException {

        StringBuilder sb = new StringBuilder();
        if (text != null && text.length() > 0 && index > 0) {
            for (String word : text.split(" ")) {
                if (word.length() >= index) {
                    sb.append(word.substring(0, index - 1)).append(symbol).append(word.substring(index, word.length()));
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
        } fileWriter(sb.toString());
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 2.	В тексте после буквы, например, Р, если она не последняя в слове,
     * ошибочно напечатана буква, например,  А,  вместо, например, О. Внести исправления в текст.
     * @param text
     * @return
     */

    public String replace(String text) throws IOException {
        StringBuilder sb = new StringBuilder();
        String newText = null;
        if(text != null) {
            for (String word : text.split(" ")) {
                newText = text.replace ("ра","ро");
            }
        } fileWriter(newText);
        System.out.println(newText);
        return newText;
    }

    /**
     * 3.	В тексте слова заданной длины заменить указанной подстрокой, длина которой может не
     * совпадать с длиной слова. (дом -> домик -> хата)
     * @param text
     */
    public String replaceSubstring(String text) {

        String[] splitString = text.split(" ");
        String newText = new String();

        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].length() == 5) {
                splitString[i] = text.substring(0, 10);
                newText += splitString[i].concat(" ");
            } else {
                newText += splitString[i].concat(" ");
            }
        } System.out.println(newText);
        return newText;
    }

    /**
     * 4.	Из небольшого (*большого ~ 10Gb) текста удалить все символы, кроме пробелов,
     * не являющиеся буквами (и рус и англ). Между последовательностями подряд идущих букв
     * оставить один пробел (= удалить лишние пробелы).
     * @param text
     */
    public String deleteSymbols(String text) {

        System.out.println();
        return text;
    }
//TODO DOESN'T WORK
    /**
     * 5.	Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
     * @param text
     * @return
     */

    public String remove(String text) throws IOException {
        char consonants[] = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц',
                            'ч', 'ш', 'щ', 'b', 'c', 'd', 'f', 'h', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r',
                            's', 't', 'v', 'w', 'x', 'y', 'z'};
        String[] splitString = text.split(" ");
        String ourFinalString = new String();


        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].length() != 5) {
                ourFinalString += splitString[i].concat(" ");
                continue;
            } else {
                for (int j = 0; j < consonants.length; j++) {
                    if (splitString[i].toLowerCase().startsWith(String.valueOf(consonants[j]))) {
                        break;
                    }
                    if (j == consonants.length - 1) {
                        ourFinalString += splitString[i].concat(" ");
                    }
                }
            }
        }
        System.out.println(ourFinalString);
        return ourFinalString;
    }

}
