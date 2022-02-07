package expression;

public class Nand extends TwoOper {
    public Nand(Base left, Base right) {
        super("#", left, right);
    }

    @Override
    public boolean oper(boolean value1, boolean value2) {
        return !(value1 && value2);
    }
}