package ru.nsu.bazarov.Commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Pop implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Pop.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Pop is performed");
        if (context.getStack().size() == 0) {
            LOGGER.warn("Stack is empty");
            return;
        }
        context.getStack().pop();
    }
}
