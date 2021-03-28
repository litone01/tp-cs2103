package seedu.sochedule.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.sochedule.testutil.TypicalTasks.ASSIGNMENT;
import static seedu.sochedule.testutil.TypicalTasks.EXERCISE;

import org.junit.jupiter.api.Test;

import seedu.sochedule.testutil.TaskBuilder;

public class CompletionStatusTest {

    @Test
    public void isValidCompletionStatus() {

        // invalid completionStatus
        assertFalse(CompletionStatus.isValidStatus("")); // empty string

        // valid completionStatus
        assertTrue(CompletionStatus.isValidStatus("INCOMPLETE"));
        assertTrue(CompletionStatus.isValidStatus("COMPLETE"));
    }

    @Test
    public void compareTest() {
        assertEquals(ASSIGNMENT.getCompletionStatus().compareTo(EXERCISE.getCompletionStatus()), 0);

        Task assignment = new TaskBuilder(ASSIGNMENT).build();
        assignment.markTaskAsDone();
        assertEquals(assignment.getCompletionStatus().compareTo(EXERCISE.getCompletionStatus()), 1);
        assertEquals(EXERCISE.getCompletionStatus().compareTo(assignment.getCompletionStatus()), -1);
    }
}
