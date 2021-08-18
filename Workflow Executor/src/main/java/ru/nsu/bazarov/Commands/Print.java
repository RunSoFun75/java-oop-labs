package ru.nsu.bazarov.Commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Print implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Print.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Print is performed");
        if (context.getStack().size() == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(context.getStack().peek());
    }
}
