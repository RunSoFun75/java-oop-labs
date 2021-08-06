package ru.nsu.bazarov;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class WordRecord {

    public static void record(String outputFileName,
                              ArrayList<Map.Entry<String, Long> > wordStatisticArray,
                              long quantityWords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Long> entry : wordStatisticArray) {
                writer.write(entry.getKey() + ",");
                writer.write(entry.getValue() + ",");
                writer.write((100.0f * ((double) entry.getValue() / quantityWords) + "%"));
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
