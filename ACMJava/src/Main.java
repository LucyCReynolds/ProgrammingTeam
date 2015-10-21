/**
 * Auburn COMP 4200 Fa15 Homework 3: Derivative-based regular expression matcher
 */
public class Main {
    public static void main(String[] args) {
        Regex regex = Regex.parse("ab*");
        System.out.println("EXAMPLE REGEX: " + regex);
        System.out.println("Nullable? " + regex.isNullable());
        System.out.println("Derivative with respect to a is " +
                regex.getDerivativeWithRespectTo('a'));

        System.out.println();

        regex = Regex.parse("(cb*+cd)*");
        System.out.println("EXAMPLE REGEX: " + regex);
        System.out.println("Empty string matches? " + regex.match(""));
        System.out.println("c matches? " + regex.match("c"));
        System.out.println("cdcbbcd matches? " + regex.match("cdcbbcd"));
        System.out.println("cdd matches? " + regex.match("cdd"));
        System.out.println("Nullable? " + regex.isNullable());
        System.out.println("Derivative with respect to c is " +
                regex.getDerivativeWithRespectTo('c'));

        System.out.println();

        regex = Regex.parse("a*");
        System.out.println("EXAMPLE REGEX: " + regex);
        System.out.println("Nullable? " + regex.isNullable());
        System.out.println("Derivative with respect to c is " +
                regex.getDerivativeWithRespectTo('c'));

        System.out.println();

        System.out.println("Running tests...");
        checkMatch("", "", true);
        checkMatch("", "a", false);
        checkMatch("a", "", false);
        checkMatch("a", "a", true);
        checkMatch("a", "b", false);
        checkMatch("a", "aa", false);
        checkMatch("ab", "", false);
        checkMatch("ab", "a", false);
        checkMatch("ab", "b", false);
        checkMatch("ab", "aa", false);
        checkMatch("ab", "ab", true);
        checkMatch("ab", "abb", false);
        checkMatch("ab", "aabb", false);
        checkMatch("abcd", "", false);
        checkMatch("abcd", "abcd", true);
        checkMatch("a*", "", true);
        checkMatch("a*", "a", true);
        checkMatch("a*", "aa", true);
        checkMatch("a*", "aaa", true);
        checkMatch("a*", "aaaa", true);
        checkMatch("a*b", "b", true);
        checkMatch("a*b", "ab", true);
        checkMatch("a*b", "aab", true);
        checkMatch("a*b", "aaab", true);
        checkMatch("a*b", "aaaab", true);
        checkMatch("a*b+c*", "", true);
        checkMatch("a*b+c*", "b", true);
        checkMatch("a*b+c*", "c", true);
        checkMatch("a*b+c*", "cc", true);
        checkMatch("a*b+c*", "ccc", true);
        checkMatch("a*b+c*", "ab", true);
        checkMatch("a*b+c*", "aab", true);
        checkMatch("a*b+c*", "aaab", true);
        checkMatch("a*b+c*", "aaaab", true);
        checkMatch("a*b+c*", "aaaabc", false);
        checkMatch("(ab)*c", "c", true);
        checkMatch("(ab)*c", "abc", true);
        checkMatch("(ab)*c", "ababc", true);
        checkMatch("(a+bc)*d", "d", true);
        checkMatch("(a+bc)*d", "ad", true);
        checkMatch("(a+bc)*d", "bcd", true);
        checkMatch("(a+bc)*d", "aad", true);
        checkMatch("(a+bc)*d", "bcbcd", true);
        checkMatch("(a+bc)*d", "abcd", true);
        checkMatch("(a+bc)*d", "bcad", true);
        checkMatch("(a+bc)*d", "abc", false);
        checkMatch("(a+bc)*d", "acd", false);
        checkMatch("a*b+c*", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc", false);

        checkMatch("(aa)*&(aaa)*", "", true);
        checkMatch("(aa)*&(aaa)*", "aa", false);
        checkMatch("(aa)*&(aaa)*", "aaa", false);
        checkMatch("(aa)*&(aaa)*", "aaaaaa", true);

        checkMatch("ab?c(de)?", "ac", true);
        checkMatch("ab?c(de)?", "abc", true);
        checkMatch("ab?c(de)?", "acde", true);
        checkMatch("ab?c(de)?", "abcde", true);

        checkMatch("a%c", "ac", false);
        checkMatch("a%c", "aac", true);
        checkMatch("a%c", "abc", true);
        checkMatch("a%c", "a9c", true);

        checkMatch("aa&aa", "", false);
        checkMatch("aa&aa", "a", false);
        checkMatch("aa&aa", "aa", true);
        checkMatch("aa&aa", "aaa", false);
        checkMatch("aa&aa", "aaaa", false);

        checkMatch("%*&(a+b)", "", false);
        checkMatch("%*&(a+b)*", "a", true);
        checkMatch("%*&(a+b)*", "b", true);
        checkMatch("%*&(a+b)*", "aa", true);
        checkMatch("%*&(a+b)*", "ab", true);
        checkMatch("%*&(a+b)*", "abaababba", true);
        checkMatch("%*&(a+b)*", "abaabacbba", false);

        System.out.println("Success!");
    }

    private static void checkMatch(String regex, String input, boolean shouldMatch) {
        boolean doesMatch = Regex.parse(regex).match(input);
        if (shouldMatch && !doesMatch) {
            System.err.printf("%s should match the input %s but does not%n",
                    regex, input);
            System.exit(1);
        } else if (!shouldMatch && doesMatch) {
            System.err.printf("%s should not match the input %s but does%n",
                    regex, input);
            System.exit(1);
        }
    }
}
