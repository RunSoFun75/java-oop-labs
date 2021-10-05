package ru.nsu.bazarov.commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Sqrt implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Sqrt.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Sqrt is performed");
        double a = context.getStack().pop();
        if (a < 0) {
            LOGGER.warn("Error, extracting the root of a negative number: " + a);
            context.getStack().push(a);
            return;
        }
        context.getStack().push(Math.sqrt(a));
    }
}
