package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TASK_ID_DESC;
import static seedu.address.logic.commands.CommandTestUtil.TASK_ID_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TASK_ID;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.task.TdelCommand;
import seedu.address.logic.parser.task.TdelCommandParser;

class TdelCommandParserTest {
    private TdelCommandParser parser = new TdelCommandParser();

    @Test
    void parse_allFieldsPresent_success() {
        Index expectedTaskID = Index.fromOneBased(VALID_TASK_ID);

        assertParseSuccess(parser, TASK_ID_DESC_ONE,
                new TdelCommand(expectedTaskID));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, TdelCommand.MESSAGE_USAGE);

        //missing task id
        assertParseFailure(parser, "", expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        //invalid task name (blank)
        assertParseFailure(parser, INVALID_TASK_ID_DESC, MESSAGE_INVALID_INDEX);
    }
}
