package seedu.sochedule.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.sochedule.testutil.TypicalTasks.ASSIGNMENT;
import static seedu.sochedule.testutil.TypicalTasks.EXERCISE;

import org.junit.jupiter.api.Test;

import seedu.sochedule.testutil.TaskBuilder;

public class PinnedStatusTest {

    @Test
    public void isValidPinnedStatus() {

        // invalid pinnedStatus
        assertFalse(PinnedStatus.isValidStatus("")); // empty string

        // valid pinnedStatus
        assertTrue(PinnedStatus.isValidStatus("PINNED"));
        assertTrue(PinnedStatus.isValidStatus("UNPINNED"));
    }

    @Test
    public void compareTest() {
        assertEquals(ASSIGNMENT.getPinnedStatus().compareTo(EXERCISE.getPinnedStatus()), 0);

        Task assignment = new TaskBuilder(ASSIGNMENT).build();

        assignment.pin();
        assertEquals(assignment.getPinnedStatus().compareTo(EXERCISE.getPinnedStatus()), 1);
        assertEquals(EXERCISE.getPinnedStatus().compareTo(assignment.getPinnedStatus()), -1);

        assignment.unpin();
        assertEquals(ASSIGNMENT.getPinnedStatus().compareTo(EXERCISE.getPinnedStatus()), 0);
    }
}
