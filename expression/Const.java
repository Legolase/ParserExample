package expression;

public class Const implements Base {
    private final boolean value;

    public Const(final boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(boolean x) {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Const cont) {
            return this.value == cont.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (value) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return (value) ? "1" : "0";
    }
}
