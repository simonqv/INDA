/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Simon Larspers Qvist
 * @version 2021-02-04
 */
public class Postfix {
    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        Stack<Integer> integerStack = new LinkedList<>();
        String[] splitExpr = expr.trim().split("\\s+");

        for (String s : splitExpr) {
            if (isInteger(s)) {
                integerStack.push(Integer.parseInt(s));

            } else if (isOperator(s) && integerStack.size() >= 2) {
                int x = integerStack.pop();
                int y = integerStack.pop();

                switch (s) {
                    case "+":
                        integerStack.push(x + y);
                        break;
                    case "-":
                        integerStack.push(y - x);
                        break;
                    case "*":
                        integerStack.push(x * y);
                        break;
                    case "/":
                        if (x == 0) {
                            throw new ExpressionException("Division by zero not allowed");
                        } else {
                            integerStack.push(y / x);
                        }
                        break;
                }
            } else {
                throw new ExpressionException("Expression is wrong");
            }
        }
        if (integerStack.size() != 1) {
            throw new ExpressionException("Expression is wrong");
        }
        return integerStack.top();
    }

    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        return s.matches("[-/+*]");
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        return s.matches("-?[1-9]\\d*") | s.matches("-?0");
    }
}
