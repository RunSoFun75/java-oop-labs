package ru.nsu.bazarov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordSort {

    public static ArrayList<Map.Entry<String, Long> > sort(HashMap<String, Long> wordStatisticMap) {
        ArrayList<Map.Entry<String, Long> > wordStatisticArray =
                new ArrayList<>(wordStatisticMap.entrySet());

        wordStatisticArray.sort(new Comparator<Map.Entry<String, Long> >() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });

        return wordStatisticArray;
    }
}
