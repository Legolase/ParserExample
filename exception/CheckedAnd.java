package exception;

import expression.Base;
import expression.TwoOper;

public class CheckedAnd extends TwoOper {
    public CheckedAnd(Base left, Base right) {
        super("&", left, right);
    }

    @Override
    public boolean oper(boolean value1, boolean value2) {
        if (value1 == value2 && !value1) {
            throw new BothZeroException();
        }
        return value1 && value2;
    }
}
