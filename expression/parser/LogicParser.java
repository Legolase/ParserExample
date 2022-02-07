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
            Base temp;
            skipWhitespaces();
            if (take('~')) {
                skipWhitespaces();
                if (take('0')) {
                    temp =  new Inversion(new Const(false));
                } else if (take('1')) {
                    temp = new Inversion(new Const(true));
                } else if (take('x')) {
                    temp = new Inversion(new Variable("x"));
                } else if (take('(')) {
                    temp = new Inversion(parseExpression());
                    expect(')');
                } else {
                    throw error("Expected const or begining of expression");
                }
            } else {
                skipWhitespaces();
                if (take('0')) {
                    temp = new Const(false);
                } else if (take('1')) {
                    temp = new Const(true);
                } else if (take('x')) {
                    temp = new Variable("x");
                } else if (take('(')) {
                    skipWhitespaces();
                    temp = parseExpression();
                    skipWhitespaces();
                    expect(')');
                } else {
                    throw error("Expected const or begining of expression");
                }
            }
            skipWhitespaces();
            return temp;
        }

        private void skipWhitespaces() {
            while(Character.isWhitespace(getCurrent())) {
                take();
            }
        }
    }
}