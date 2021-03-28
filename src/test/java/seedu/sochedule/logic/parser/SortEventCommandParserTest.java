package seedu.sochedule.logic.parser;

import static seedu.sochedule.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.sochedule.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.sochedule.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.sochedule.logic.commands.SortEventCommand;
import seedu.sochedule.model.event.EventComparator;

public class SortEventCommandParserTest {
    private SortEventCommandParser parser = new SortEventCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        for (String comparingVar : EventComparator.getAcceptedVar()) {
            assertParseSuccess(parser, comparingVar, new SortEventCommand(comparingVar));
        }
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, ")($*!()",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortEventCommand.MESSAGE_USAGE));
    }
}
