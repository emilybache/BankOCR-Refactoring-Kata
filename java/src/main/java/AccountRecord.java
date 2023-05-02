public class AccountRecord {
    private char[] work;
    public static final int DIGIT_COUNT = 8;

    public AccountRecord() {
        work = "             ".toCharArray();
        this.initializeAllDigitsToQuestionmark();
    }

    void assignDigitFromLines(String[] lines, int pos, int rowOffset, int columnOffset) {
        boolean foundADigit = false;

        for (Ocr.Numeral n : Ocr.Numeral.values()) {
            CharacterField field = CharacterField.fromLines(rowOffset, columnOffset, lines);
            if (field.compareTo(n)) {
                assignPositionToDigit(pos, n.asChar());
                foundADigit = true;
            }

        }
        if (!foundADigit) {
            markRecordAsIllegal();
        }
    }

    private void initializeAllDigitsToQuestionmark() {
        for (int pos = 0; pos < 9; ++pos) {
            setPositionToQuestionMark(pos);
        }
    }

    String getResult() {
        return new String(work);
    }

    private void markRecordAsIllegal() {
        work[10] = 'I';
        work[11] = work[12] = 'L';
    }

    private void assignPositionToDigit(int pos, char characterForTheNumeralWeFound) {
        work[pos] = characterForTheNumeralWeFound;
    }

    private void setPositionToQuestionMark(int pos) {
        work[pos] = '?';
    }
}
