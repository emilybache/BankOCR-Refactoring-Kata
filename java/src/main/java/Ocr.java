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
            int rowOffset = i;
            final char[] work = "             ".toCharArray();
            for (int pos = 0; pos < 9; ++pos) {
                int columnOffset = 4 * pos;
                work[pos] = '?';
                boolean got1 = false;
                for (int numeral = 0; numeral <= 9; ++numeral) {
                    boolean ok = true;

                    char[][] sixteenCharactersWereTryingToRecognize = getTheNextSixteenCharacters(rowOffset, columnOffset, lines);
                    if (!compareTwoCharArrays(NUMERALS[numeral], sixteenCharactersWereTryingToRecognize))
                        ok = false;

                    if (ok) {
                        char characterForTheNumeralWeFound = ("" + numeral).charAt(0);
                        work[pos] = characterForTheNumeralWeFound;
                        got1 = true;
                        break;
                    }
                }
                if (!got1) {
                    work[10] = 'I';
                    work[11] = work[12] = 'L';
                }
            }
            result.add(new String(work));
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
