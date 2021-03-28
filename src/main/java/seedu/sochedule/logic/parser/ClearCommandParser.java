package seedu.sochedule.logic.parser;

import seedu.sochedule.logic.commands.ClearCommand;

public class ClearCommandParser implements Parser<ClearCommand> {
    /**
     * Returns a ClearCommand object for execution.
     */
    public ClearCommand parse(String args) {
        return new ClearCommand();
    }
}
