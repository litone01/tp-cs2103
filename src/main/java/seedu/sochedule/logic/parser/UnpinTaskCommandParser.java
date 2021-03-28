package seedu.sochedule.logic.parser;

import static seedu.sochedule.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.sochedule.commons.core.index.Index;
import seedu.sochedule.logic.commands.UnpinTaskCommand;
import seedu.sochedule.logic.parser.exceptions.ParseException;

public class UnpinTaskCommandParser implements Parser<UnpinTaskCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the UnpinTaskCommand
     * and returns a UnpinTaskCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnpinTaskCommand parse(String args) throws ParseException {
        try {
            Index index = SocheduleParserUtil.parseIndex(args);
            return new UnpinTaskCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnpinTaskCommand.MESSAGE_USAGE), pe);
        }
    }
}
