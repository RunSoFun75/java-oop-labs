package ru.nsu.bazarov;

import ru.nsu.bazarov.commands.Command;
import ru.nsu.bazarov.exceptions.BuildCommandException;
import ru.nsu.bazarov.exceptions.CommandNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class FactoryCommand {

    private static final Logger LOGGER = LogManager.getLogger(FactoryCommand.class);
    private static final Properties factorySetting = new Properties();

    private static FactoryCommand instance;

    public static synchronized FactoryCommand getInstance() {
        if (instance == null) {
            instance = new FactoryCommand();
        }
        return instance;
    }

    private FactoryCommand() {
        try {
            factorySetting.load(FactoryCommand.class
                    .getClassLoader()
                    .getResourceAsStream("FactorySetting.properties"));
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }

    public Command buildCommand(String commandName) throws CommandNotFoundException, BuildCommandException {
        if (!factorySetting.containsKey(commandName)) {
            throw new CommandNotFoundException("Command doesn't exist");
        }
        Command command;
        try {
            command = (Command) Class.forName(factorySetting.getProperty(commandName))
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            throw new BuildCommandException("failed to create a command");
        }
        return command;
    }
}
