package seedu.sochedule.logic.commands;

import static seedu.sochedule.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.sochedule.testutil.TypicalEvents.getTypicalSochedule;

import org.junit.jupiter.api.Test;

import seedu.sochedule.model.Model;
import seedu.sochedule.model.ModelManager;
import seedu.sochedule.model.UserPrefs;
import seedu.sochedule.model.event.EventComparator;

public class SortEventCommandTest {
    private Model model = new ModelManager(getTypicalSochedule(), new UserPrefs());

    @Test
    public void execute_valid_success() {
        for (String comparingVar : EventComparator.getAcceptedVar()) {
            SortEventCommand sortEventCommand = new SortEventCommand(comparingVar);

            String expectedMessage = String.format(SortEventCommand.MESSAGE_SORT_TASK_SUCCESS);

            ModelManager expectedModel = new ModelManager(model.getSochedule(), new UserPrefs());
            expectedModel.sortEvents(comparingVar);

            assertCommandSuccess(sortEventCommand, model, expectedMessage, expectedModel);
        }
    }

    // invalid inputs already handled on parsing sort_event command
}
