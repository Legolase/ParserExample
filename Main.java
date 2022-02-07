import expression.*;

public class Main {
    public static void main(String args[]) {
        Base expression = new And (
                new Nor(new Variable("x"), new Const(false)),
                new Inversion(new Variable("x"))
        );
        System.out.println(expression.evaluate(true));
    } //(x nor 0) and (!x)
}
