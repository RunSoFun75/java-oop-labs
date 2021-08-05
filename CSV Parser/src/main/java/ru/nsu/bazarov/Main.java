package ru.nsu.bazarov;

public class Main {

    private static final int QUANTITY_ARGUMENTS = 2;
    private static final int INPUT_FILE_NAME = 0;
    private static final int OUTPUT_FILE_NAME = 1;
    private static final int EXIT_FAILURE = 1;

    public static void main(String[] args) {
        if (args.length != QUANTITY_ARGUMENTS) {
            System.err.println("invalid number of program arguments");
            System.exit(EXIT_FAILURE);
        }

        new WordStatisticService(args[INPUT_FILE_NAME], args[OUTPUT_FILE_NAME]).createStatistic();
    }
}
