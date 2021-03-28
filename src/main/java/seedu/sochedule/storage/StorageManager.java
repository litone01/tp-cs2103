package seedu.sochedule.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.sochedule.commons.core.LogsCenter;
import seedu.sochedule.commons.exceptions.DataConversionException;
import seedu.sochedule.model.ReadOnlySochedule;
import seedu.sochedule.model.ReadOnlyUserPrefs;
import seedu.sochedule.model.UserPrefs;

/**
 * Manages storage of Sochedule data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private UserPrefsStorage userPrefsStorage;
    private SocheduleStorage socheduleStorage;

    /**
     * Creates a {@code SocheduleStorageManager} with the given {@code socheduleStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(SocheduleStorage socheduleStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.userPrefsStorage = userPrefsStorage;
        this.socheduleStorage = socheduleStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }
    // ================ Sochedule methods ==============================

    @Override
    public Path getSocheduleFilePath() {
        return socheduleStorage.getSocheduleFilePath();
    }

    @Override
    public Optional<ReadOnlySochedule> readSochedule() throws DataConversionException, IOException {
        return readSochedule(socheduleStorage.getSocheduleFilePath());
    }

    @Override
    public Optional<ReadOnlySochedule> readSochedule(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return socheduleStorage.readSochedule(filePath);
    }

    @Override
    public void saveSochedule(ReadOnlySochedule sochedule) throws IOException {
        saveSochedule(sochedule, getSocheduleFilePath());
    }

    @Override
    public void saveSochedule(ReadOnlySochedule sochedule, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        socheduleStorage.saveSochedule(sochedule, filePath);
    }
}
