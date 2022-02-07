package expression;

public class Inversion extends OneOper {
    public Inversion(Base vyrashenie) {
        super("~", vyrashenie);
    }

    @Override
    public boolean oper(boolean value) {
        return (value) ? false : true;
    }
}
