package seedu.sochedule.logic.commands;

import static seedu.sochedule.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.sochedule.logic.commands.CommandTestUtil.showTaskAtIndex;
import static seedu.sochedule.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.sochedule.testutil.TypicalTasks.getTypicalSochedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.sochedule.model.Model;
import seedu.sochedule.model.ModelManager;
import seedu.sochedule.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListTaskCommand.
 */
public class ListTaskCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalSochedule(), new UserPrefs());
        expectedModel = new ModelManager(model.getSochedule(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListTaskCommand(), model, ListTaskCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showTaskAtIndex(model, INDEX_FIRST_TASK);
        assertCommandSuccess(new ListTaskCommand(), model, ListTaskCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
