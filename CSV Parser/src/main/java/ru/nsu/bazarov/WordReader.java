package ru.nsu.bazarov;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordReader {

    private final String inputFileName;

    private long quantityWords = 0;

    public WordReader(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public HashMap<String, Long> getWordStatistic() {
        HashMap<String, Long> wordStatisticMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // everything except these characters is considered a delimiter
                String wordSeparatorRegex = "[^a-яА-Яa-zA-Z0-9]";
                for (String word : currentLine.split(wordSeparatorRegex)) {
                    if (!word.isEmpty()) {
                        quantityWords++;
                        if (wordStatisticMap.containsKey(word)) {
                            wordStatisticMap.replace(word, wordStatisticMap.get(word) + 1);
                        } else {
                            wordStatisticMap.put(word, 1L);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return wordStatisticMap;
    }

    public long getQuantityWords() {
        return quantityWords;
    }
}