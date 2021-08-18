package ru.nsu.bazarov.Commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Push implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Push.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Push is performed");
        try {
            if (context.getDefines().containsKey(inputArguments.get(0))) {
                context.getStack().push(context.getDefines().get(inputArguments.get(0)));
            } else {
                context.getStack().push(Double.valueOf(inputArguments.get(0)));
            }
        } catch (NumberFormatException ex) {
            LOGGER.error(ex);
        }
    }
}
