package seedu.sochedule.logic.parser;

import static seedu.sochedule.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.sochedule.commons.core.index.Index;
import seedu.sochedule.logic.commands.DeleteEventCommand;
import seedu.sochedule.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteEventCommand object
 */
public class DeleteEventCommandParser implements Parser<DeleteEventCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteEventCommand
     * and returns a DeleteEventCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteEventCommand parse(String args) throws ParseException {
        try {
            Index index = SocheduleParserUtil.parseIndex(args);
            return new DeleteEventCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteEventCommand.MESSAGE_USAGE), pe);
        }
    }

}
