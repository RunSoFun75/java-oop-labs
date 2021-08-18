package ru.nsu.bazarov.Commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Division implements Command{

    private static final Logger LOGGER = LogManager.getLogger(Division.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Division is performed");
        if (context.getStack().size() < 2) {
            LOGGER.warn("not enough operands to execute");
            return;
        }
        double a = context.getStack().pop();
        double b = context.getStack().pop();
        if (b == 0) {
            LOGGER.warn("Error, division by zero!");
            context.getStack().push(b);
            context.getStack().push(a);
            return;
        }
        context.getStack().push(a / b);
    }
}
