package expression;

public class Nor extends TwoOper {
    public Nor(Base left, Base right) {
        super("*", left, right);
    }

    @Override
    public boolean oper(boolean value1, boolean value2) {
        return !(value1 && value2);
    }
}