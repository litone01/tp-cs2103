package seedu.sochedule.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.sochedule.commons.core.GuiSettings;
import seedu.sochedule.logic.commands.CommandResult;
import seedu.sochedule.logic.commands.exceptions.CommandException;
import seedu.sochedule.logic.parser.exceptions.ParseException;
import seedu.sochedule.model.Model;
import seedu.sochedule.model.ReadOnlySochedule;
import seedu.sochedule.model.event.Event;
import seedu.sochedule.model.task.Task;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the user prefs' sochedule file path.
     */
    Path getSocheduleFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the Sochedule taskList.
     *
     * @see Model#getSochedule()
     */
    ReadOnlySochedule getSochedule();

    /** Returns an unmodifiable view of the filtered list of tasks */
    ObservableList<Task> getFilteredTaskList();


    /** Returns an unmodifiable view of the filtered list of events */
    ObservableList<Event> getFilteredEventList();

}
