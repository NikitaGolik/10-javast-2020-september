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
     * @param offer
     * @param index
     * @param symbol
     * @return
     */

    public String replaceSymbol(String offer, int index, char symbol) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (offer != null && offer.length() > 0 && index > 0) {
            for (String word : offer.split(" ")) {
                if (word.length() >= index) {
                    sb.append(word.substring(0, index - 1)).append(symbol).append(word.substring(index, word.length()));
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
        } fileWriter(sb.toString());
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
        if(text != null) {
            for (String word : text.split(" ")) {
                text = text.replace ("ра","ро");
            }
        } fileWriter(text);
        return text;
    }

    /**
     * 3.	В тексте слова заданной длины заменить указанной подстрокой, длина которой может не
     * совпадать с длиной слова. (дом -> домик -> хата)
     * @param text
     */

    public String replaceSubstring (String text) throws IOException {
        String newText = null;
        newText = text.replaceAll("\\b[a-zA-Z]{5}\\b", "JAVA");
        fileWriter(newText);
        return newText;
    }

    /**
     * 4.	Из небольшого (*большого ~ 10Gb) текста удалить все символы, кроме пробелов,
     * не являющиеся буквами (и рус и англ). Между последовательностями подряд идущих букв
     * оставить один пробел (= удалить лишние пробелы).
     * @param text
     */

    public String deleteSymbols (String text) throws IOException {
        String newText = null;
        newText =  text.replaceAll("(?u)[^\\pL ]","");
        fileWriter(newText);
        return newText;
    }

    /**
     * 5.	Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
     * @param text
     * @return
     */

    //TODO DOESN'T WORK
    public String remove(String text) throws IOException {
        String[] strArr = text.split(" ");//разбиваем текст на массив слов
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<strArr.length;i++){

            char first = strArr[i].charAt(0); // первая буква каждого слова

            if(!((strArr[i].length() % 5 == 0) && ((first != 'b') && (first != 'c') && (first != 'd') &&
                    (first != 'f') && (first != 'g') && (first != 'h') && (first != 'j') && (first != 'k') &&
                    (first != 'l') && (first != 'm') && (first != 'n') && (first != 'p') && (first != 'q') &&
                    (first != 'r') && (first != 's') && (first != 't') && (first != 'v') && (first != 'w') &&
                    (first != 'x') && (first != 'y') && (first != 'z') && (first != 'б') && (first != 'в') &&
                    (first != 'г') && (first != 'д') && (first != 'ж') && (first != 'з') && (first != 'к') &&
                    (first != 'л') && (first != 'м') && (first != 'н') && (first != 'п') && (first != 'р') &&
                    (first != 'с') && (first != 'т') && (first != 'ф') && (first != 'х') && (first != 'ц') &&
                    (first != 'ч') && (first != 'ш')&&(first != 'щ'))))
            {

                sb.append(strArr[i]).append(" ");
            }
        }
        String newText = sb.toString().trim();
        fileWriter(newText);
        return newText;
    }

}
