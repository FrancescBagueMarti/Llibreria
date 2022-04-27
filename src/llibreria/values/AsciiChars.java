package llibreria.values;

public enum AsciiChars {
    CHECK_MARK(10003),
    BALLOT_X(10007)
    ;

    private final char value;
    private AsciiChars(int val) {
        this.value = (char) val;
    }
    @Override
    public String toString(){
        return ""+this.value;
    }
    public static char get(int unicode) {
        return (char) unicode;
    }
}
