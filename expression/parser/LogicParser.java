package expression.parser;

import expression.*;
import base_parser.*;

public class LogicParser {
    public Base parse(final String expression) {
        return parse(new StringCharSource(expression));
    }

    public Base parse(final CharSource source) {
        return new LONParser(source).parse();
    }

    private final class LONParser extends BaseParser {
        public LONParser(CharSource source) {
            super(source);
        }

        public Base parse() {
            Base temp = parseExpression();
            if (!end()) {
                throw error("Expected end of expression");
            }
            return temp;
        }

        private Base parseExpression() {
            Base temp = parseTerm();
            while(test('#') || test('*')) {
                if (take('#')) {
                    temp = new Nand(temp, parseTerm());
                } else if (take('*')) {
                    temp = new Nor(temp, parseTerm());
                }
            }
            return temp;
        }

        private Base parseTerm() {
            Base temp = parseStruct();
            while(test('&') || test('|')) {
                if (take('&')) {
                    temp = new And(temp, parseStruct());
                } else if (take('|')) {
                    temp = new Or(temp, parseStruct());
                }
            }
            return temp;
        }

        private Base parseStruct() {
            if (take('~')) {
                if (take('0')) {
                    return new Inversion(new Const(false));
                } else if (take('1')) {
                    return new Inversion(new Const(true));
                } else if (take('x')) {
                    return new Inversion(new Variable("x"));
                } else if (take('(')) {
                    Base temp = new Inversion(parseExpression());
                    expect(')');
                    return temp;
                } else {
                    throw error("Expected const or begining of expression");
                }
            } else if (take('0')) {
                return new Const(false);
            } else if (take('1')) {
                return new Const(true);
            } else if (take('x')) {
                return new Variable("x");
            } else if (take('(')) {
                Base temp = parseExpression();
                expect(')');
                return temp;
            } else {
                throw error("Expected const or begining of expression");
            }
        }
    }
}