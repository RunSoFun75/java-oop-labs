package ru.nsu.bazarov;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final int INPUT_FILE_NAME = 0;

    public static void main(String[] args) {
        LOGGER.info("Start program");

        new StackCalculator(args.length == 0 ? null : args[INPUT_FILE_NAME]).calculate();
    }
}