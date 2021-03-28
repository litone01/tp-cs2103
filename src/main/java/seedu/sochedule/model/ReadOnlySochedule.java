package seedu.sochedule.model;

import javafx.collections.ObservableList;
import seedu.sochedule.model.event.Event;
import seedu.sochedule.model.task.Task;

/**
 * Unmodifiable view of Sochedule
 */
public interface ReadOnlySochedule {

    /**
     * Returns an unmodifiable view of the Tasks list.
     * This list will not contain any duplicate tasks.
     */
    ObservableList<Task> getTaskList();

    /**
     * Returns an unmodifiable view of the Events list.
     * This list will not contain any duplicate events.
     */
    ObservableList<Event> getEventList();
}
