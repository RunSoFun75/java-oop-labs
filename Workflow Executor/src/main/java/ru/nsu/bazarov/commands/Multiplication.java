package ru.nsu.bazarov.commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Multiplication implements Command{

    private static final Logger LOGGER = LogManager.getLogger(Multiplication.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Multiplication is performed");
        if (context.getStack().size() < 2) {
            LOGGER.warn("not enough operands to execute");
            return;
        }
        double a = context.getStack().pop();
        double b = context.getStack().pop();
        context.getStack().push(a * b);
    }
}
