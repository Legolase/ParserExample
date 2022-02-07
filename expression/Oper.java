package expression;

public abstract class Oper implements Base {
    private final String simvol;

    public Oper(final String simvol) {
        this.simvol = simvol;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Oper op) {
            return simvol.equals(op.simvol);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return simvol.hashCode();
    }
}
