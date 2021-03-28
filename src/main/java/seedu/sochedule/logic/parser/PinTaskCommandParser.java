package seedu.sochedule.logic.parser;

import static seedu.sochedule.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.sochedule.commons.core.index.Index;
import seedu.sochedule.logic.commands.PinTaskCommand;
import seedu.sochedule.logic.parser.exceptions.ParseException;

public class PinTaskCommandParser implements Parser<PinTaskCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the PinTaskCommand
     * and returns a PinTaskCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public PinTaskCommand parse(String args) throws ParseException {
        try {
            Index index = SocheduleParserUtil.parseIndex(args);
            return new PinTaskCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, PinTaskCommand.MESSAGE_USAGE), pe);
        }
    }
}
