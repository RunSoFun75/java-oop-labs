package ru.nsu.bazarov.commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Define implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Define.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Define is performed");
        try {
            context.getDefines().put(inputArguments.get(0), Double.valueOf(inputArguments.get(1)));
        } catch (NumberFormatException ex) {
            LOGGER.error(ex);
        }
    }
}
