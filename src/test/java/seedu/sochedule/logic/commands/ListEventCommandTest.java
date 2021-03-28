package seedu.sochedule.logic.commands;

import static seedu.sochedule.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.sochedule.logic.commands.CommandTestUtil.showEventAtIndex;
import static seedu.sochedule.testutil.TypicalEvents.getTypicalSochedule;
import static seedu.sochedule.testutil.TypicalIndexes.INDEX_FIRST_EVENT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.sochedule.model.Model;
import seedu.sochedule.model.ModelManager;
import seedu.sochedule.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListEventCommand.
 */
public class ListEventCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalSochedule(), new UserPrefs());
        expectedModel = new ModelManager(model.getSochedule(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListEventCommand(), model, ListEventCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showEventAtIndex(model, INDEX_FIRST_EVENT);
        assertCommandSuccess(new ListEventCommand(), model, ListEventCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
