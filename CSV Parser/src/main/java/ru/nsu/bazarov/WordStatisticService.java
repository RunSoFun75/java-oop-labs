package ru.nsu.bazarov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordStatisticService {

    private final String inputFileName;
    private final String outputFileName;

    HashMap<String, Long> wordStatisticMap; // read
    ArrayList<Map.Entry<String, Long> > wordStatisticArray; // output

    long quantityWords;

    public WordStatisticService(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public void createStatistic() {
        WordReader reader = new WordReader(inputFileName);
        wordStatisticMap = reader.getWordStatistic();
        quantityWords = reader.getQuantityWords();

        // wordStatisticMap -> wordStatisticArray
        wordStatisticArray = WordSort.sort(wordStatisticMap);

        WordRecord.record(outputFileName, wordStatisticArray, quantityWords);
    }
}
