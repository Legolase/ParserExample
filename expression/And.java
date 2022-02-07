package expression;

public class And extends TwoOper {
    public And(Base left, Base right) {
        super("&", left, right);
    }

    @Override
    public boolean oper(boolean value1, boolean value2) {
        return value1 && value2;
    }
}
