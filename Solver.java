public class Solver {
    public static void main(String[] args) {
        solve("(2 + (2 + (2 + 2)) * 3)");
    }

    public static void solve(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.substring(i, i + 1).equals("(")) {
                for (int j = expression.length() - 1; j > i; j--) {
                    if (expression.charAt(j) == ')') {
                        solve(expression.substring(i + 1, j));
                        
                        break;
                    }
                }

                break;

            }
        }
    }

    public static int solve2(String first, String operator, String second) {
        if (operator.equals("+")) {
            return Integer.parseInt(first) + Integer.parseInt(second);
        } else if (operator.equals("-")) {
            return Integer.parseInt(first) - Integer.parseInt(second);
        } else if (operator.equals("/")) {
            return Integer.parseInt(first) / Integer.parseInt(second);
        } else if (operator.equals("*")) {
            return Integer.parseInt(first) * Integer.parseInt(second);
        } else if (operator.equals("^")) {
            return (int) Math.pow(Integer.parseInt(first), Integer.parseInt(second));
        }

        return 0;
    }
}