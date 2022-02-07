package expression;

public abstract class TwoOper extends Oper {
    private final Base left, right;

    public TwoOper(String simvol, Base left, Base right) {
        super(simvol);
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TwoOper two) {
            return this.left.equals(two.left) &&
                    this.right.equals(two.right) &&
                    ((Oper)this).equals(two);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 43 * super.hashCode() + left.hashCode()*13 + right.hashCode()*53;
    }

    public abstract boolean oper(final boolean value1, final boolean value2);

    @Override
    public boolean evaluate(boolean x) {
        return oper(left.evaluate(x), right.evaluate(x));
    }
}
