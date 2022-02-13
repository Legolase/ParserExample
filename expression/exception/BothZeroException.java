package exception;

public class BothZeroException extends CalcException {
    private static String DEFAULT_MESSAGE = "Both zeroes are prohibited";
    public BothZeroException() {
        super(DEFAULT_MESSAGE);
    }

    public BothZeroException(String message, Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }
}
