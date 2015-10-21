/**
 * A regular expression, represented as an expression tree.
 * <p>
 * Solution by Lucy Reynolds
 */
public final class Regex {
    /**
     * Constant for the Unicode empty set character.
     * <p>
     * A regex that matches nothing can be constructed by
     * <code>new Regex(Regex.EMPTY_SET, null, null)</code>.
     */
    public static final char EMPTY_SET = '\u2205';

    /**
     * Constant for the Unicode lower case epsilon character.
     * <p>
     * A regex that matches the empty string can be constructed by
     * <code>new Regex(Regex.EPSILON, null, null)</code>.
     */
    public static final char EPSILON = '\u03B5';

    /** @return a {@link Regex} object corresponding to the given string. */
    public static Regex parse(String regex) {
        return new RegexParser().parse(regex);
    }

    /**
     * The regular expression operator: one of + . * {@link #EPSILON} or
     * {@link #EMPTY_SET}
     */
    private final char operator;

    /**
     * The left-hand operand if the operator is + or ., or the sole operand if
     * the operator is *, or <code>null</code> otherwise
     */
    private final Regex operand1;

    /**
     * The right-hand operand if the operator is + or ., or <code>null</code>
     * otherwise
     */
    private final Regex operand2;

    /**
     * Constructor. Creates a regex with the given operator and operands.
     * <p>
     * If the operator is '+' (alternation) or '.' (concatenation), both
     * operands must be non-<code>null</code>.
     * <p>
     * If the operator is '*' (Kleene closure), operand1 must be non-
     * <code>null</code> and operand2 must be <code>null</code>
     * <p>
     * For any other operator, both operands must be <code>null</code>.
     */
    public Regex(char operator, Regex operand1, Regex operand2) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        if (!isValid()) {
            throw new IllegalArgumentException("Invalid regex " + this);
        }
    }

    /**
     * @return true iff each operator in this regular expression has the correct
     *         number of operands.
     */
    private boolean isValid() {
        switch (operator) {
            case '*':
                return operand1 != null && operand1.isValid() && operand2 == null;
            case '.':
            case '+':
                return operand1 != null && operand1.isValid()
                        && operand2 != null && operand2.isValid();
            case '%':
                return operand1 == null && operand2 == null;
            case '&':
                return operand1 != null && operand1.isValid() && operand2 != null && operand2.isValid();
            case '?':
                return operand1 != null && operand1.isValid() && operand2 == null;
            default:
                return operand1 == null && operand2 == null;
        }
    }

    /**
     * @return true iff this regular expression is nullable (i.e., the language
     *         of this regex includes the empty string).
     */
    public boolean isNullable() {
        switch (operator) {
            case EPSILON:
            case '*':
                return true;
            case '.':
                return operand1.isNullable() && operand2.isNullable();
            case '+':
                return operand1.isNullable() || operand2.isNullable();
            case '%':
                return false;
            case '?':
                return true;
            case '&':
                return operand1.isNullable() && operand2.isNullable();
            case EMPTY_SET:
            default:
                return false;
        }
    }

    /**
     * @return the derivative of this regular expression with respect to the
     *         given symbol (simplified)
     */
    public Regex getDerivativeWithRespectTo(char letterOrDigit) {
        if (!Character.isLetterOrDigit(letterOrDigit)) {
            throw new IllegalArgumentException(
                    "Argument to getDerivativeWithRespectTo must be letter or digit");
        }
        switch (operator) {
            case EMPTY_SET:
            case EPSILON:
                return new Regex(EMPTY_SET, null, null);
            case '*':
                return new Regex('.',
                        operand1.getDerivativeWithRespectTo(letterOrDigit),
                        this).simplified();
            case '.':
                return new Regex('+',
                        new Regex('.',
                                operand1.getDerivativeWithRespectTo(letterOrDigit),
                                operand2).simplified(),
                        new Regex('.',
                                operand1.getNu(),
                                operand2.getDerivativeWithRespectTo(letterOrDigit)).simplified()).simplified();
            case '+':
                return new Regex('+',
                        operand1.getDerivativeWithRespectTo(letterOrDigit),
                        operand2.getDerivativeWithRespectTo(letterOrDigit)).simplified();
            case '%':
                return new Regex(EPSILON,null,null);
            case '&':
                return new Regex('&', operand1.getDerivativeWithRespectTo(letterOrDigit).simplified(), operand2.getDerivativeWithRespectTo(letterOrDigit).simplified());
            case '?':
                return new Regex('.', operand1.getDerivativeWithRespectTo(letterOrDigit).simplified(), new Regex(EPSILON,null,null));
            default:
                if (this.operator == letterOrDigit) {
                    return new Regex(EPSILON, null, null);
                } else {
                    return new Regex(EMPTY_SET, null, null);
                }
        }
    }

    /**
     * @return a simplified regular expression computed by applying the
     *         algebraic rules for identities, annihilators, and idempotence.
     *         Assumes subexpressions have already been simplified.
     */
    private Regex simplified() {
        switch (operator) {
            case '.':
                if (operand1.operator == EMPTY_SET)
                    return operand1;
                if (operand2.operator == EMPTY_SET)
                    return operand2;
                if (operand1.operator == EPSILON)
                    return operand2;
                if (operand2.operator == EPSILON)
                    return operand1;
                break;
            case '+':
                if (operand1.equals(operand2))
                    return operand1;
                if (operand1.operator == EMPTY_SET)
                    return operand2;
                if (operand2.operator == EMPTY_SET)
                    return operand1;
                break;
            case '&':
                if(operand1.equals(operand2))
                    return operand1;
                if(operand1.operator == EMPTY_SET)
                    return operand2;
                if(operand2.operator == EMPTY_SET)
                    return operand1;
                break;
        }
        return this;
    }

    /** @return the value of the nu function for this regular expression */
    private Regex getNu() {
        return new Regex(isNullable() ? EPSILON : EMPTY_SET, null, null);
    }

    /** @return true iff the given input matches this regular expression */
    public boolean match(String input) {
        if (input == null)
            return false;

        Regex regex = this;
        for (int i = 0, len = input.length(); i < len; i++) {
            regex = regex.getDerivativeWithRespectTo(input.charAt(i));
        }
        return regex.isNullable();
    }

    /**
     * @return a string representation of this regular expression with no
     *         unnecessary parentheses
     */
    @Override
    public String toString() {
        if (operator == '.') {
            return parenthesizeIfNecessary(operand1, true)
                    + parenthesizeIfNecessary(operand2, false);
        } else if (operator == EPSILON) {
            return String.valueOf(EPSILON); // "(epsilon)";
        } else if (operator == EMPTY_SET) {
            return String.valueOf(EMPTY_SET); // "(empty set)";
        } else {
            return parenthesizeIfNecessary(operand1, true)
                    + operator
                    + parenthesizeIfNecessary(operand2, false);
        }
    }

    private String parenthesizeIfNecessary(Regex operand, boolean isLeftArgument) {
        if (operand == null) {
            return "";
        } else if (operand.hasHigherPrecedenceThan(this)) {
            return operand.toString();
        } else if (operand.hasSamePrecedenceAs(this) && isLeftArgument) {
            return operand.toString();
        } else {
            return "(" + operand.toString() + ")";
        }
    }

    private boolean hasSamePrecedenceAs(Regex that) {
        return this.operator == that.operator;
    }

    private boolean hasHigherPrecedenceThan(Regex that) {
        switch (this.operator) {
            case '+':
                return false;
            case '&':
                return that.operator == '+';
            case '.':
                return that.operator == '+' || that.operator == '&';
            case '*':
            case '?':
                return that.operator == '+' || that.operator == '&' || that.operator == '.';
            default:
                return that.operator == '+' || that.operator == '&' || that.operator == '.' || that.operator == '*';
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((operand1 == null) ? 0 : operand1.hashCode());
        result = prime * result + ((operand2 == null) ? 0 : operand2.hashCode());
        return prime * result + operator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Regex other = (Regex) obj;
        if (operand1 == null) {
            if (other.operand1 != null) {
                return false;
            }
        } else if (!operand1.equals(other.operand1)) {
            return false;
        }
        if (operand2 == null) {
            if (other.operand2 != null) {
                return false;
            }
        } else if (!operand2.equals(other.operand2)) {
            return false;
        }
        if (operator != other.operator) {
            return false;
        }
        return true;
    }
}
