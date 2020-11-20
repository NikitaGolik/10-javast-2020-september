package by.golik.task09.controller;

import by.golik.task09.entity.Paragraph;
import by.golik.task09.entity.Sentence;
import by.golik.task09.service.handler.ParagraphParser;
import by.golik.task09.service.handler.SymbolParser;
import by.golik.task09.service.handler.TextParser;
import by.golik.task09.service.handler2.ParserSentence;
import by.golik.task09.service.handler2.ParserText;
import by.golik.task09.service.put.Reader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;



/**
 * @author Nikita Golik
 */
public class MainController {

    public static void main(String[] args) throws IOException {
        // файлы для вывода информации

       String fromFileName = ".\\resources\\data\\text2.txt";
       String toFileName1 = ".\\resources\\data\\formatted.txt";


//         создаем парсер и делаем разбор текста
//        TextParser textParser = new TextParser(fromFileName, Charset.forName("utf-8"));
//        textParser.doParse();
        Reader reader = new Reader(fromFileName);
        ParserText parserText = new ParserText();
        parserText.doParse();

        // возьмем массив предложений из текста
//        ArrayList<Sentence> sl = (ArrayList<Sentence>) parserSentence.getSentencesList();

        // это вывод в консоль (раскоментировать или закомментировать текст ниже)
//        try (Writer writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
//            // изначальный текст, который прочитали из файла
//            textParser.printFileContent(writer);
//            writer.write(10);
//
//            // текст, который получается из массива с предложениями
//            textParser.printListTextElements(writer, sl);
//            writer.write(10);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // конец блока вывода в консоль

//        // это вывод в файлы (раскоментировать или закомментировать текст ниже)
//        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toFileName1)))) {
//            // изначальный текст, который прочитали из файла
//            textParser.printFileContent(writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
