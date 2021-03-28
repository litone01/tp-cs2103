package seedu.sochedule.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.sochedule.commons.core.GuiSettings;
import seedu.sochedule.commons.core.LogsCenter;
import seedu.sochedule.logic.commands.Command;
import seedu.sochedule.logic.commands.CommandResult;
import seedu.sochedule.logic.commands.exceptions.CommandException;
import seedu.sochedule.logic.parser.SocheduleParser;
import seedu.sochedule.logic.parser.exceptions.ParseException;
import seedu.sochedule.model.Model;
import seedu.sochedule.model.ReadOnlySochedule;
import seedu.sochedule.model.event.Event;
import seedu.sochedule.model.task.Task;
import seedu.sochedule.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final SocheduleParser socheduleParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        socheduleParser = new SocheduleParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = socheduleParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveSochedule(model.getSochedule());
        } catch (IOException ioe) {
            logger.warning(FILE_OPS_ERROR_MESSAGE + ioe);
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public Path getSocheduleFilePath() {
        return model.getSocheduleFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }

    @Override
    public ReadOnlySochedule getSochedule() {
        return model.getSochedule();
    }

    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return model.getFilteredTaskList();
    }

    @Override
    public ObservableList<Event> getFilteredEventList() {
        return model.getFilteredEventList();
    }
}
