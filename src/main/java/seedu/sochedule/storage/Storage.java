package seedu.sochedule.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.sochedule.commons.exceptions.DataConversionException;
import seedu.sochedule.model.ReadOnlySochedule;
import seedu.sochedule.model.ReadOnlyUserPrefs;
import seedu.sochedule.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends UserPrefsStorage, SocheduleStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getSocheduleFilePath();

    @Override
    Optional<ReadOnlySochedule> readSochedule() throws DataConversionException, IOException;

    @Override
    void saveSochedule(ReadOnlySochedule sochedule) throws IOException;
}
