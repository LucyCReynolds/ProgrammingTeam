/**
 * Regular expression parser: parses a string to create a {@link Regex} object.
 * <p>
 * Invoke using (for example): <code>new RegexParser().parse("(a+b)*")</code>.
 * <p>
 * This is a recursive descent parser. The exact regex syntax is described by
 * the following grammar:
 *
 * <pre>
 *         regex ::= alternation
 *   alternation ::= intersection ['+' intersection ...]
 *  intersection ::= concatenation ['&' concatenation ...]
 * concatenation ::= unary [unary ...]
 *         unary ::= primary [ ('*'|'?') ...]
 *       primary ::= [A-Za-z0-9] | '%' | '(' alternation ')'
 * </pre>
 *
 * @author Jeff Overbey
 *
 * @see Regex
 */
public final class RegexParser {

    /** The substring of the input that has not yet been parsed. */
    private String remainingInput;

    /**
     * Parses a regular expression, returning a {@link Regex} object.
     *
     * @param regex
     *            string to parse, or "" for the epsilon regex, or
     *            <code>null</code> for the empty set regex
     * @return {@link Regex}
     */
    public Regex parse(String regex) {
        if (regex == null) {
            return new Regex(Regex.EMPTY_SET, null, null);
        } else if (regex.equals("")) {
            return new Regex(Regex.EPSILON, null, null);
        } else {
            remainingInput = regex;
            return parseAlternation();
        }
    }

    private Regex parseAlternation() {
        Regex result = parseIntersection();
        while (remainingInput.startsWith("+")) {
            remainingInput = remainingInput.substring(1);
            result = new Regex('+', result, parseIntersection());
        }
        return result;
    }

    private Regex parseIntersection() {
        Regex result = parseConcatenation();
        while (remainingInput.startsWith("&")) {
            remainingInput = remainingInput.substring(1);
            result = new Regex('&', result, parseConcatenation());
        }
        return result;
    }

    private Regex parseConcatenation() {
        Regex result = parseUnary();
        while (!remainingInput.isEmpty()
                && (Character.isLetterOrDigit(remainingInput.charAt(0))
                || remainingInput.charAt(0) == '%'
                || remainingInput.charAt(0) == '(')) {
            result = new Regex('.', result, parseUnary());
        }
        return result;
    }

    private Regex parseUnary() {
        Regex result = parsePrimary();
        while (!remainingInput.isEmpty() &&
                (remainingInput.charAt(0) == '*'
                        || remainingInput.charAt(0) == '?')) {
            result = new Regex(remainingInput.charAt(0), result, null);
            remainingInput = remainingInput.substring(1);
        }
        return result;
    }

    private Regex parsePrimary() {
        if (remainingInput.isEmpty()) {
            throw new Error("Invalid regular expression - regex is incomplete");
        } else if (Character.isLetterOrDigit(remainingInput.charAt(0))
                || remainingInput.charAt(0) == '%') {
            final Regex result = new Regex(remainingInput.charAt(0), null, null);
            remainingInput = remainingInput.substring(1);
            return result;
        } else if (remainingInput.charAt(0) == '(') {
            remainingInput = remainingInput.substring(1);
            final Regex result = parseAlternation();
            if (remainingInput.charAt(0) == ')') {
                remainingInput = remainingInput.substring(1);
            } else {
                throw new Error("Invalid regular expression - expected ) at "
                        + remainingInput);
            }
            return result;
        } else {
            throw new Error(
                    "Invalid regular expression - expected letter, digit, or ( at "
                            + remainingInput);
        }
    }
}
