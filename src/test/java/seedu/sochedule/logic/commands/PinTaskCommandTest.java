package seedu.sochedule.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.sochedule.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.sochedule.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.sochedule.testutil.TypicalIndexes.INDEX_SECOND_TASK;
import static seedu.sochedule.testutil.TypicalTasks.getTypicalSochedule;

import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.sochedule.commons.core.Messages;
import seedu.sochedule.commons.core.index.Index;
import seedu.sochedule.logic.commands.exceptions.CommandException;
import seedu.sochedule.model.Model;
import seedu.sochedule.model.ModelManager;
import seedu.sochedule.model.UserPrefs;
import seedu.sochedule.model.common.Category;
import seedu.sochedule.model.common.Date;
import seedu.sochedule.model.common.Name;
import seedu.sochedule.model.common.Tag;
import seedu.sochedule.model.task.Priority;
import seedu.sochedule.model.task.Task;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code PinTaskCommand}.
 */
public class PinTaskCommandTest {
    private Model model = new ModelManager(getTypicalSochedule(), new UserPrefs());

    @Test
    public void execute_validIndexList_success() {
        Task taskToPin = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task taskToPinCopy = copyTask(taskToPin); //copy to preserve integrity
        model.setTask(taskToPin, taskToPinCopy);
        PinTaskCommand pinTaskCommand = new PinTaskCommand(INDEX_FIRST_TASK);

        String expectedMessage = PinTaskCommand.MESSAGE_PIN_TASK_SUCCESS;
        try {
            CommandResult result = pinTaskCommand.execute(model);
            assertEquals(result, new CommandResult(expectedMessage));
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }

        ModelManager expectedModel = new ModelManager(model.getSochedule(), new UserPrefs());
        Task copiedTask = copyTask(taskToPin);
        expectedModel.setTask(taskToPin, copiedTask);
        expectedModel.pinTask(copiedTask);

        assertEquals(model.getFilteredTaskList(), expectedModel.getFilteredTaskList());
    }

    @Test
    public void execute_invalidIndexList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        PinTaskCommand pinTaskCommand = new PinTaskCommand(outOfBoundIndex);

        assertCommandFailure(pinTaskCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        PinTaskCommand pinFirstTaskCommand = new PinTaskCommand(INDEX_FIRST_TASK);
        PinTaskCommand pinSecondTaskCommand = new PinTaskCommand(INDEX_SECOND_TASK);

        // same object -> returns true
        assertTrue(pinFirstTaskCommand.equals(pinFirstTaskCommand));

        // same values -> returns true
        PinTaskCommand deleteFirstCommandCopy = new PinTaskCommand(INDEX_FIRST_TASK);
        assertTrue(pinFirstTaskCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(pinFirstTaskCommand.equals(1));

        // null -> returns false
        assertFalse(pinFirstTaskCommand.equals(null));

        // different task -> returns false
        assertFalse(pinFirstTaskCommand.equals(pinSecondTaskCommand));
    }

    /**
     * Copies the task given and returns a new task with the same details as the given task.
     *
     * @param taskToCopy task to be copied, here is the task to pin.
     * @return a copied task.
     */
    private static Task copyTask(Task taskToCopy) {
        Name taskName = taskToCopy.getName();
        Date deadline = taskToCopy.getDeadline();
        Priority priority = taskToCopy.getPriority();
        Set<Category> categories = taskToCopy.getCategories();
        Set<Tag> tags = taskToCopy.getTags();

        Task copiedTask = new Task(taskName, deadline, priority, categories, tags);
        if (taskToCopy.isComplete()) {
            copiedTask.markTaskAsDone();
        }
        return copiedTask;
    }
}
