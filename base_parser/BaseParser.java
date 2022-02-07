package base_parser;

public class BaseParser {
    private static final char END = 0;
    private final CharSource source;
    private char current;

    public BaseParser(final CharSource source) {
        this.source = source;
        take();
    }

    public BaseParser(final String string) {
        this.source = new StringCharSource(string);
    }

    protected boolean test(final char expected) {
        return expected == current;
    }

    protected boolean end() {
        return test(END);
    }

    protected char take() {
        final char saved = current;
        current = source.hasNext() ? source.next() : END;
        return saved;
    }

    protected boolean take(final char expected) {
        if (test(expected)) {
            take();
            return true;
        }
        return false;
    }

    protected void expect(final char expected) {
        if (!take(expected)) {
            throw error(String.format(
                    "Expected %s, found %s",
                    expected, current != END ? current : "END OF INPUT")
            );
        }
    }

    protected boolean between(final char left, final char right) {
        return current >= left && current <= right;
    }

    protected IllegalArgumentException error(final String message) {
        return source.error(message);
    }
}
