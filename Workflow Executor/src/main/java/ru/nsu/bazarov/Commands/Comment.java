package ru.nsu.bazarov.Commands;

import ru.nsu.bazarov.ExecutionContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Comment implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Comment.class);

    @Override
    public void execute(ExecutionContext context, List<String> inputArguments) {
        LOGGER.info("Comment is performed");
    }
}
