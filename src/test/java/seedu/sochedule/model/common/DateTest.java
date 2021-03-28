package seedu.sochedule.model.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.sochedule.testutil.Assert.assertThrows;
import static seedu.sochedule.testutil.TypicalTasks.ASSIGNMENT;
import static seedu.sochedule.testutil.TypicalTasks.EXERCISE;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Date(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new Date(invalidDate));
    }

    @Test
    public void isValidDate() {
        // null date
        assertThrows(NullPointerException.class, () -> Date.isValidDate(null));

        // invalid date
        assertFalse(Date.isValidDate("")); // empty string
        assertFalse(Date.isValidDate("2023-02-29")); // invalid date
        assertFalse(Date.isValidDate("2021-03-32")); // invalid date
        assertFalse(Date.isValidDate("abcde")); // invalid date

        // valid dates
        assertTrue(Date.isValidDate("2022-02-13"));
        assertTrue(Date.isValidDate("2022-10-10"));
        assertTrue(Date.isValidDate("2022-04-30"));
    }

    @Test
    public void compareTest() {
        assertEquals(ASSIGNMENT.getDeadline().compareTo(EXERCISE.getDeadline()),
                ASSIGNMENT.getDeadline().date.compareTo(EXERCISE.getDeadline().date));
    }
}
