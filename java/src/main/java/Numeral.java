public enum Numeral {
    zero(new char[][]{
            " _  ".toCharArray(),
            "| | ".toCharArray(),
            "|_| ".toCharArray(),
            "    ".toCharArray()}, 0),
    one(new char[][]{
            "    ".toCharArray(),
            "  | ".toCharArray(),
            "  | ".toCharArray(),
            "    ".toCharArray()}, 1),
    two(new char[][]{
            " _  ".toCharArray(),
            " _| ".toCharArray(),
            "|_  ".toCharArray(),
            "    ".toCharArray()}, 2),
    three(new char[][]{
            " _  ".toCharArray(),
            " _| ".toCharArray(),
            " _| ".toCharArray(),
            "    ".toCharArray()}, 3),
    four(new char[][]{
            "    ".toCharArray(),
            "|_| ".toCharArray(),
            "  | ".toCharArray(),
            "    ".toCharArray()}, 4),
    five(new char[][]{
            " _  ".toCharArray(),
            "|_  ".toCharArray(),
            " _| ".toCharArray(),
            "    ".toCharArray()}, 5),
    six(new char[][]{
            " _  ".toCharArray(),
            "|_  ".toCharArray(),
            "|_| ".toCharArray(),
            "    ".toCharArray()}, 6),
    seven(new char[][]{
            " _  ".toCharArray(),
            "  | ".toCharArray(),
            "  | ".toCharArray(),
            "    ".toCharArray()}, 7),
    eight(new char[][]{
            " _  ".toCharArray(),
            "|_| ".toCharArray(),
            "|_| ".toCharArray(),
            "    ".toCharArray()}, 8),
    nine(new char[][]{
            " _  ".toCharArray(),
            "|_| ".toCharArray(),
            " _| ".toCharArray(),
            "    ".toCharArray()}, 9);
    private final char[][] value;
    private final int numeral;

    Numeral(char[][] value, int numeral) {
        this.value = value;
        this.numeral = numeral;
    }

    char asChar() {
        return ("" + numeral).charAt(0);
    }

    boolean compareTo(char[][] other) {
        return CharacterField.compareTwoCharArrays(value, other);
    }

}
