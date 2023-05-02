import java.util.List;
import java.util.ArrayList;

public class Ocr {

    public static List<String> parse(String... lines) {
        final List<String> result = new ArrayList<String>();
        for (int i = 0; i < lines.length; i += CharacterField.FIELD_HEIGHT) {
            AccountRecord accountRecord = new AccountRecord();
            int rowOffset = i;
            for (int digitIndex = 0; digitIndex <= AccountRecord.DIGIT_COUNT; ++digitIndex) {
                int columnOffset = CharacterField.FIELD_WIDTH * digitIndex;
                accountRecord.assignDigitFromLines(lines, digitIndex, rowOffset, columnOffset);
            }
            result.add(accountRecord.getResult());
        }
        return result;
    }

}
