package seedu.sochedule.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.sochedule.model.Model;
import seedu.sochedule.model.Sochedule;


/**
 * Clears the Sochedule.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Sochedule has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setSochedule(new Sochedule());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

