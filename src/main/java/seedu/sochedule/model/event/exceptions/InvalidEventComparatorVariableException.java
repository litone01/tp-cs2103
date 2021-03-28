package seedu.sochedule.model.task.exceptions;

public class InvalidEventComparatorVariableException extends RuntimeException {
    public InvalidEventComparatorVariableException() {
        super("Invalid Comparator Input detected");
    }
}
