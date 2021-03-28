package seedu.sochedule.model;

import java.nio.file.Path;

import seedu.sochedule.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getSocheduleFilePath();


}
