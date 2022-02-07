package expression;

public class Variable implements Base {
    private final String variable;

    public Variable(final String variable) {
        this.variable = variable;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Variable v) {
            return this.variable.equals(v.variable);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
    }

    @Override
    public boolean evaluate(boolean x) {
        return x;
    }
}
