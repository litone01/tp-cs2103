package seedu.sochedule.logic.parser;

import seedu.sochedule.logic.commands.SummaryCommand;

public class SummaryCommandParser implements Parser<SummaryCommand> {
    /**
     * Returns a SummaryCommand object for execution.
     */
    public SummaryCommand parse(String args) {
        return new SummaryCommand();
    }
}
