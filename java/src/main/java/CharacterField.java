public class CharacterField {

    public static final int FIELD_WIDTH = 4;
    public static final int FIELD_HEIGHT = 4;
    public char[][] value;

    public CharacterField(char[][] value) {
        this.value = value;
    }

    static CharacterField fromLines(int rowOffset, int columnOffset, String[] lines) {
        return new CharacterField(getTheNextSixteenCharacters(rowOffset, columnOffset, lines));
    }


    static char[][] getTheNextSixteenCharacters(int rowOffset, int columnOffset, String[] lines) {
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

    boolean compareTo(Ocr.Numeral digit) {
        return digit.compareTo(this.value);
    }
    boolean compareTo(char[][] digit) {
        return compareTwoCharArrays(digit, this.value);
    }

    public static boolean compareTwoCharArrays(char[][] digit1, char[][] digit2) {
        for (int row = 0; row < 4; ++row) {
            for (int col = 0; col < 4; ++col) {
                if (digit1[row][col] != digit2[row][col])
                    return false;
            }
        }
        return true;
    }
}
