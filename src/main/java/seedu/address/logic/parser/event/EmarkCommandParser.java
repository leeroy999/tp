package seedu.address.logic.parser.event;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBER_ID;

import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.event.EmarkCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EmarkCommand object
 */
public class EmarkCommandParser implements Parser<EmarkCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EmarkCommand
     * and returns a EmarkCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EmarkCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_EVENT_ID, PREFIX_MEMBER_ID);
        if (!ParserUtil.arePrefixesPresent(argMultimap, PREFIX_EVENT_ID, PREFIX_MEMBER_ID)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EmarkCommand.MESSAGE_USAGE));
        }
        Index index = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_EVENT_ID).get());
        Set<Index> memberIndices = ParserUtil.parseIndices(argMultimap.getAllValues(PREFIX_MEMBER_ID));
        return new EmarkCommand(index, memberIndices);
    }
}