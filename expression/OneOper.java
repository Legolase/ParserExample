package expression;

public abstract class OneOper extends Oper {
    private final Base vyrashenie;

    public OneOper(String simvol, Base vyrashenie) {
        super(simvol);
        this.vyrashenie = vyrashenie;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof OneOper one) {
            return this.vyrashenie.equals(one.vyrashenie) && ((Oper)this).equals(one);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 43 * super.hashCode() + vyrashenie.hashCode()*13;
    }

    public abstract boolean oper(final boolean value);

    @Override
    public boolean evaluate(boolean x) {
        return oper(vyrashenie.evaluate(x));
    }

    @Override
    public String toString() {
        return super.toString() + vyrashenie.toString();
    }
}
