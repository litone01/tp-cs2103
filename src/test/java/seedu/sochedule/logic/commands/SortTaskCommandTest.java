package seedu.sochedule.logic.commands;

import static seedu.sochedule.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.sochedule.testutil.TypicalTasks.getTypicalSochedule;

import org.junit.jupiter.api.Test;

import seedu.sochedule.model.Model;
import seedu.sochedule.model.ModelManager;
import seedu.sochedule.model.UserPrefs;
import seedu.sochedule.model.task.TaskComparator;

public class SortTaskCommandTest {
    private Model model = new ModelManager(getTypicalSochedule(), new UserPrefs());

    @Test
    public void execute_valid_success() {
        for (String comparingVar : TaskComparator.getAcceptedVar()) {
            SortTaskCommand sortTaskCommand = new SortTaskCommand(comparingVar);

            String expectedMessage = String.format(SortTaskCommand.MESSAGE_SORT_TASK_SUCCESS);

            ModelManager expectedModel = new ModelManager(model.getSochedule(), new UserPrefs());
            expectedModel.sortTasks(comparingVar);

            assertCommandSuccess(sortTaskCommand, model, expectedMessage, expectedModel);
        }
    }

    // invalid inputs already handled on parsing sort_task command
}
