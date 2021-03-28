package seedu.sochedule.logic.parser;

import static seedu.sochedule.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.sochedule.commons.core.index.Index;
import seedu.sochedule.logic.commands.DeleteTaskCommand;
import seedu.sochedule.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteTaskCommand object
 */
public class DeleteTaskCommandParser implements Parser<DeleteTaskCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteTaskCommand
     * and returns a DeleteTaskCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteTaskCommand parse(String args) throws ParseException {
        try {
            Index index = SocheduleParserUtil.parseIndex(args);
            return new DeleteTaskCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteTaskCommand.MESSAGE_USAGE), pe);
        }
    }

}
