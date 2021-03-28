package seedu.sochedule.logic.parser;

import static seedu.sochedule.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.sochedule.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.sochedule.logic.commands.AddEventCommand;
import seedu.sochedule.logic.commands.AddTaskCommand;
import seedu.sochedule.logic.commands.ClearCommand;
import seedu.sochedule.logic.commands.ClearCompletedTaskCommand;
import seedu.sochedule.logic.commands.ClearExpiredEventCommand;
import seedu.sochedule.logic.commands.ClearExpiredTaskCommand;
import seedu.sochedule.logic.commands.Command;
import seedu.sochedule.logic.commands.DeleteEventCommand;
import seedu.sochedule.logic.commands.DeleteTaskCommand;
import seedu.sochedule.logic.commands.DoneTaskCommand;
import seedu.sochedule.logic.commands.EditTaskCommand;
import seedu.sochedule.logic.commands.ExitCommand;
import seedu.sochedule.logic.commands.FindEventCommand;
import seedu.sochedule.logic.commands.FindTaskCommand;
import seedu.sochedule.logic.commands.HelpCommand;
import seedu.sochedule.logic.commands.ListEventCommand;
import seedu.sochedule.logic.commands.ListTaskCommand;
import seedu.sochedule.logic.commands.PinTaskCommand;
import seedu.sochedule.logic.commands.SortEventCommand;
import seedu.sochedule.logic.commands.SortTaskCommand;
import seedu.sochedule.logic.commands.SummaryCommand;
import seedu.sochedule.logic.commands.UnpinTaskCommand;
import seedu.sochedule.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 * Currently not doing any real work, will be improved in v1.2
 */
public class SocheduleParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    @SuppressWarnings("checkstyle:Regexp")
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddTaskCommand.COMMAND_WORD:
            return new AddTaskCommandParser().parse(arguments);

        case AddEventCommand.COMMAND_WORD:
            return new AddEventCommandParser().parse(arguments);

        case DeleteTaskCommand.COMMAND_WORD:
            return new DeleteTaskCommandParser().parse(arguments);

        case DeleteEventCommand.COMMAND_WORD:
            return new DeleteEventCommandParser().parse(arguments);

        case DoneTaskCommand.COMMAND_WORD:
            return new DoneTaskCommandParser().parse(arguments);

        case FindTaskCommand.COMMAND_WORD:
            return new FindTaskCommandParser().parse(arguments);

        case FindEventCommand.COMMAND_WORD:
            return new FindEventCommandParser().parse(arguments);

        case EditTaskCommand.COMMAND_WORD:
            return new EditTaskCommandParser().parse(arguments);

        case SortTaskCommand.COMMAND_WORD:
            return new SortTaskCommandParser().parse(arguments);

        case PinTaskCommand.COMMAND_WORD:
            return new PinTaskCommandParser().parse(arguments);

        case UnpinTaskCommand.COMMAND_WORD:
            return new UnpinTaskCommandParser().parse(arguments);

        case SortEventCommand.COMMAND_WORD:
            return new SortEventCommandParser().parse(arguments);

        case SummaryCommand.COMMAND_WORD:
            return new SummaryCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommandParser().parse(arguments);

        case ClearExpiredTaskCommand.COMMAND_WORD:
            return new ClearExpiredTaskCommand();

        case ClearCompletedTaskCommand.COMMAND_WORD:
            return new ClearCompletedTaskCommand();

        case ClearExpiredEventCommand.COMMAND_WORD:
            return new ClearExpiredEventCommand();

        case ListTaskCommand.COMMAND_WORD:
            return new ListTaskCommand();

        case ListEventCommand.COMMAND_WORD:
            return new ListEventCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
