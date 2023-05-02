import java.util.List;
import java.util.ArrayList;

public class Ocr {

    static boolean compareTwoCharArrays(char[][] digit1, char[][] digit2) {
        for (int row = 0; row < 4; ++row) {
            for (int col = 0; col < 4; ++col) {
                if (digit1[row][col] != digit2[row][col])
                    return false;
            }
        }
        return true;
    }

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

                    char[][] sixteenCharactersWereTryingToRecognize = getTheNextSixteenCharacters(rowOffset, columnOffset, lines);
                    if (compareTwoCharArrays(NUMERALS[numeral], sixteenCharactersWereTryingToRecognize)) {
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

    private static char[][] getTheNextSixteenCharacters(int rowOffset, int columnOffset, String[] lines) {
        char[][] sixteenCharactersWereTryingToRecognize = new char[4][];
        for (int row = 0; row < 4; ++row) {
            sixteenCharactersWereTryingToRecognize[row] = new char[4];
            for (int col = 0; col < 4; ++col) {
                char c = lines[rowOffset + row].charAt(columnOffset + col);
                sixteenCharactersWereTryingToRecognize[row][col] = c;

            }
        }
        return sixteenCharactersWereTryingToRecognize;
    }
}
