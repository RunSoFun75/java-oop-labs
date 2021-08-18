package ru.nsu.bazarov.Commands;

import ru.nsu.bazarov.ExecutionContext;

import java.util.List;

public interface Command {

    public void execute(ExecutionContext context, List<String> inputArguments);
}
