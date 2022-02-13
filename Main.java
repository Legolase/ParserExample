import expression.Base;
import expression.parser.LogicParser;

public class Main {
    public static void main(String args[]) {
        String str = "x&0*x";
        Base expression = new LogicParser().parse(str);
        System.out.println(expression);
        System.out.println(expression.evaluate(false));
    }
}
