package ru.nsu.bazarov.exceptions;

public class CommandNotFoundException extends Exception {

    public CommandNotFoundException(String message) {
        super(message);
    }
}
