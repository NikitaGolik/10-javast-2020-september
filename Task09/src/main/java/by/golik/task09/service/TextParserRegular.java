package by.golik.task09.service;

import by.golik.task09.entity.Sentence;
import by.golik.task09.entity.Symbol;
import by.golik.task09.entity.Word;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikita Golik
 */
public class TextParserRegular {


    // полный путь к файлу
    private String fileName;

    // кодировка файла
    private Charset fileEncoding;

    // текст из файла
    private String fileContent;

    // список предложений
    private List<Sentence> sentencesList = new ArrayList<Sentence>();
    // список слов
    private List<Word> wordsList = new ArrayList<Word>();
    // список символов
    private List<Symbol> symbolsList = new ArrayList<Symbol>();

    // конструктор
    public TextParserRegular(String fileName, Charset fileEncoding) {
        this.fileName = fileName;
        this.fileEncoding = fileEncoding;
    }

    // геттеры
    public List<Sentence> getSentencesList() {
        return sentencesList;
    }

    public List<Word> getWordsList() {
        return wordsList;
    }

    public List<Symbol> getSymbolsList() {
        return symbolsList;
    }

    // читает текст из файла
    private void readFromFile() throws IOException
    {
        byte[] textEncoded = Files.readAllBytes(Paths.get(fileName));

        fileContent = new String(textEncoded, fileEncoding);
    }

    // убирает из текста лишние пробелы
    private void trimFileContent() {
        fileContent = fileContent.replaceAll(REGEX_SPACES, " ");
    }

    // метод разбора текста на элементы
    public void doParse() {
        try {
            // читаем текст из файла
            readFromFile();
            // убираем из текста лишние пробелы
            trimFileContent();

            // парсим текст на элементы
            parseToSentences();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод разбирает текст на массив предложений
    private void parseToSentences() {
        Pattern patternSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = patternSentence.matcher(fileContent);

        while (matcher.find()) {
            String sentenceString = matcher.group();

            Sentence sentence = parseToWords(sentenceString);

            sentencesList.add(sentence);
        }
    }

    // метод разбирает предложения на массив слов и прочих символов
    private Sentence parseToWords(String sentenceString) {
        Pattern patternWord = Pattern.compile(REGEX_WORD_OR_PUNCTUATION);
        Matcher matcher = patternWord.matcher(sentenceString);

        ArrayList<WordOrPunctuation> arrWords = new ArrayList<WordOrPunctuation>();

        while (matcher.find()) {
            String wordString = matcher.group();

            WordOrPunctuation word = parseToSymbols(wordString);

            // установим признак слово или нет
            word.setIsWord(wordString.matches(REGEX_WORD));

            arrWords.add(word);
            wordsList.add(word);
        }

        return new Sentence(arrWords);
    }

    // метод разбирает слова и прочие символы на массив конечных символов
    private WordOrPunctuation parseToSymbols(String wordString) {
        Pattern patternSymbol = Pattern.compile(REGEX_SYMBOL);
        Matcher matcher = patternSymbol.matcher(wordString);

        ArrayList<Symbol> arrWordSymbols = new ArrayList<Symbol>();

        while (matcher.find()) {
            String stringSymbol = matcher.group();

            Symbol symbol = new Symbol(stringSymbol.charAt(0));

            arrWordSymbols.add(symbol);
            symbolsList.add(symbol);
        }

        return new WordOrPunctuation(arrWordSymbols);
    }

}
