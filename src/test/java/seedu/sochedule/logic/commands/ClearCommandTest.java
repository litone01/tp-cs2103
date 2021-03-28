package seedu.sochedule.logic.commands;

import static seedu.sochedule.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.sochedule.testutil.TypicalTasks.getTypicalSochedule;

import org.junit.jupiter.api.Test;

import seedu.sochedule.model.Model;
import seedu.sochedule.model.ModelManager;
import seedu.sochedule.model.Sochedule;
import seedu.sochedule.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptySochedule_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptySochedule_success() {
        Model model = new ModelManager(getTypicalSochedule(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalSochedule(), new UserPrefs());
        expectedModel.setSochedule(new Sochedule());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
