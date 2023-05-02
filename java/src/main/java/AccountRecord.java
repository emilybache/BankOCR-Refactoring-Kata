public class AccountRecord {
    private char[] work;

    public AccountRecord() {
        work = "             ".toCharArray();
    }

    String getResult() {
        return new String(work);
    }

    void markRecordAsIllegal() {
        work[10] = 'I';
        work[11] = work[12] = 'L';
    }

    void assignPositionToDigit(int pos, char characterForTheNumeralWeFound) {
        work[pos] = characterForTheNumeralWeFound;
    }

    void setPositionToQuestionMark(int pos) {
        work[pos] = '?';
    }
}
