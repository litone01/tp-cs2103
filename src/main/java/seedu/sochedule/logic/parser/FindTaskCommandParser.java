package seedu.sochedule.logic.parser;

import static seedu.sochedule.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.sochedule.logic.commands.FindTaskCommand;
import seedu.sochedule.logic.parser.exceptions.ParseException;
import seedu.sochedule.model.task.TaskNameContainsKeywordsPredicate;

public class FindTaskCommandParser implements Parser<FindTaskCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindTaskCommand
     * and returns a FindTaskCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindTaskCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindTaskCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindTaskCommand(new TaskNameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
