package base_parser;

public class StringCharSource implements CharSource {
    private final String source;
    private int pos;

    public StringCharSource(final String source) {
        this.source = source;
        pos = 0;
    }

    @Override
    public char next() {
        return source.charAt(pos++);
    }

    @Override
    public boolean hasNext() {
        return pos < source.length();
    }

    @Override
    public IllegalArgumentException error(String message) {
        return new IllegalArgumentException(
                String.format("%d : %s (rest of input\"%s\")",
                        pos, message, source.substring(pos))
        );
    }
}
