import java.util.List;
import java.util.ArrayList;

public class Ocr {

    static class Numeral {
        public Numeral(char[][] characters) {

        }
        static char[][] zero = {
                " _  ".toCharArray(),
                "| | ".toCharArray(),
                "|_| ".toCharArray(),
                "    ".toCharArray()};
    }

    private static final char[][][] NUMERALS = new char[][][] {
        {" _  ".toCharArray(),
         "| | ".toCharArray(),
         "|_| ".toCharArray(),
         "    ".toCharArray()},
        {"    ".toCharArray(),
         "  | ".toCharArray(),
         "  | ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         " _| ".toCharArray(),
         "|_  ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         " _| ".toCharArray(),
         " _| ".toCharArray(),
         "    ".toCharArray()},
        {"    ".toCharArray(),
         "|_| ".toCharArray(),
         "  | ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_  ".toCharArray(),
         " _| ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_  ".toCharArray(),
         "|_| ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "  | ".toCharArray(),
         "  | ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_| ".toCharArray(),
         "|_| ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_| ".toCharArray(),
         " _| ".toCharArray(),
         "    ".toCharArray()}};

    public static List<String> parse(String... lines) {
        final List<String> result = new ArrayList<String>();
        for (int i = 0; i < lines.length; i += 4) {
            AccountRecord accountRecord = new AccountRecord();
            int rowOffset = i;

            for (int pos = 0; pos < 9; ++pos) {
                int columnOffset = 4 * pos;
                accountRecord.setPositionToQuestionMark(pos);
                boolean foundADigit = false;
                for (int numeral = 0; numeral <= 9; ++numeral) {

                    CharacterField field = CharacterField.fromLines(rowOffset, columnOffset, lines);
                    if (field.compareTo(NUMERALS[numeral])) {
                        char characterForTheNumeralWeFound = ("" + numeral).charAt(0);
                        accountRecord.assignPositionToDigit(pos, characterForTheNumeralWeFound);
                        foundADigit = true;
                        break;
                    }

                }
                if (!foundADigit) {
                    accountRecord.markRecordAsIllegal();
                }
            }
            result.add(accountRecord.getResult());
        }
        return result;
    }

}
