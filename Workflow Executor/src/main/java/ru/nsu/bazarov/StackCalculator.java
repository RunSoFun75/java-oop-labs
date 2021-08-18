package ru.nsu.bazarov;

import ru.nsu.bazarov.Commands.Command;
import ru.nsu.bazarov.Exceptions.BuildCommandException;
import ru.nsu.bazarov.Exceptions.CommandNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StackCalculator {

    private static final Logger LOGGER = LogManager.getLogger(StackCalculator.class);
    private static final String SEPARATOR_SPACE_REGEX = "\\s++";

    private BufferedReader reader;

    public StackCalculator(String inputStream) {
        try {
            if (inputStream == null) {
                LOGGER.info("Calculator works in console mode");
                reader = new BufferedReader(new InputStreamReader(System.in));
            } else {
                LOGGER.info("Calculator works with file");
                reader = new BufferedReader(new FileReader(inputStream));
            }
        } catch (FileNotFoundException ex) {
            LOGGER.error(ex);
        }
    }

    public void calculate() {
        ExecutionContext context = new ExecutionContext();
        List<String> inputArguments;
        try {
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String[] commandLine = currentLine.split(SEPARATOR_SPACE_REGEX);
                try {
                    Command command = FactoryCommand.getInstance().buildCommand(commandLine[0]);
                    inputArguments = Arrays.asList(commandLine).subList(1, commandLine.length);
                    command.execute(context, inputArguments);
                } catch (CommandNotFoundException | BuildCommandException ex) {
                    LOGGER.error(ex);
                }
            }
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }
}
