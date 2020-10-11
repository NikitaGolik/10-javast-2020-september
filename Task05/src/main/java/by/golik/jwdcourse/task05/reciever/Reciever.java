package by.golik.jwdcourse.task05.reciever;

import by.golik.jwdcourse.task05.bean.Document;
import by.golik.jwdcourse.task05.command.TypeCommand;

import java.util.Scanner;

public class Reciever {
    private Document document;
    public void action(TypeCommand cmd) {
        switch (cmd) {
            case ONE:
                break;
            case TWO:
                break;
            case THREE:
                break;
            case FOUR:
                break;
        }
    }
    public static String replaceSymbol(String offer, int index, char symbol) {
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
        }
        return sb.toString();
    }
    public String replace(String text) {
        Scanner sc=new Scanner (System.in);
        System.out.println("введите текст");
        text = sc.nextLine();
        text = text.replace ("pa","po");
        return text;
    }
    public static void replaceSubstring () {
        String ourString = "В тексте слова заданной длины заменить указанной подстрокой, длина которой может не " +
                "совпадать с длиной слова";
        String[] splitString = ourString.split(" ");
        String ourFinalString = new String();

        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].length() == 5) {
                splitString[i] = ourString.substring(30,43);
                ourFinalString += splitString[i].concat(" ");
            } else {
                ourFinalString += splitString[i].concat(" ");
            }
        }

        System.out.println(ourFinalString);
        System.out.println();
    }
    public static void deleteSymbols () {
        String ourString = "Из небольшого текста удалить все символы, кроме пробелов, неявляющиеся буквами. "
                + "Между последовательностями подряд идущих букв оставить хотя бы один пробел.";
        char ch[] = new char[ourString.length()];
        String ourFinalString = new String();

        ourString.getChars(0, ourString.length(), ch, 0);
        for (int i = 0; i < ch.length; i++) {
            if ((Character.isAlphabetic(ch[i])) || (Character.isSpaceChar(ch[i]))) {
                ourFinalString += ch[i];
            }
        }

        System.out.println(ourFinalString);
        System.out.println();
    }
    public String remove(String text) {
        String[] strArr = text.split(" ");//разбиваем текст на массив слов
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<strArr.length;i++){

            char first = strArr[i].charAt(0); // первая буква каждого слова

            if(!((strArr[i].length()%5==0)  &&  ((first != 'a')&&(first != 'e')&&(first != 'i')&&(first != 'o')&&(first != 'u')&&(first != 'y')))){

                sb.append(strArr[i]).append(" ");
            }

        }
        String outText = sb.toString().trim();

        // вывод результата
        System.out.print(outText+" "+"\n\n");
        return outText;
    }

}
