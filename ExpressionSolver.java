public class ExpressionSolver {
    public static void main(String[] args) {
        System.out.println(eval("(3 + 62) + (4 * 3)"));
    }

    public static String eval(String expression) {
        // Solve parentheses First
        int depth = 0; int startParenthesis = -1; int endParanthesis = -1;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                if (depth == 0) {
                    startParenthesis = Integer.valueOf(i);
                }
                depth++;
            } else if (expression.charAt(i) == ')') {
                depth--;
                if (depth == 0) {
                    endParanthesis = Integer.valueOf(i);
                    String s = eval(expression.substring(startParenthesis + 1, endParanthesis));
                    expression = expression.substring(0, startParenthesis) + s + expression.substring(endParanthesis + 1, expression.length());
                    i = -1;
                }
            }
        }
        return solve(expression);
    }

    public static String solve(String expression) {
        
        // Exponents first
        while (expression.contains("^")) {
            int i = expression.indexOf("^"); int x = i - 2; int y = i + 2; String first = ""; String second = "";
            while (x >= 0) {
                if (expression.charAt(x) == ' ') break;
                first = expression.charAt(x) + first;
                x--;
            }
            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') break;
                second = second + expression.charAt(y);
                y++;
            }
            int z = (int) Math.pow(Integer.parseInt(first), Integer.parseInt(second));
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }
        // Then Division and Multiplication
        while (expression.contains("*") || expression.contains("/")) {
            int a = expression.indexOf("*"); int b = expression.indexOf("/");
            int i = (b < 0 || a < b) && a > 0? a: b; int x = i - 2; int y = i + 2; String first = ""; String second = "";
            while (x >= 0) {
                if (expression.charAt(x) == ' ') break;
                first = expression.charAt(x) + first;
                x--;
            }
            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') break;
                second = second + expression.charAt(y);
                y++;
            }
            int z = expression.charAt(i) == '/' ? Integer.parseInt(first) / Integer.parseInt(second) : Integer.parseInt(first) * Integer.parseInt(second);
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }
        // Then Addition and Subtraction
        while (expression.contains("+") || expression.contains("- ")) {
            int a = expression.indexOf("+"); int b = expression.indexOf("- ");
            int i = (b < 0 || a < b) && a > 0? a: b; int x = i - 2; int y = i + 2; String first = ""; String second = "";
            while (x >= 0) {
                if (expression.charAt(x) == ' ') break;
                first = expression.charAt(x) + first;
                x--;
            }
            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') break;
                second = second + expression.charAt(y);
                y++;
            }
            int z = expression.charAt(i) == '+' ? Integer.parseInt(first) + Integer.parseInt(second) : Integer.parseInt(first) - Integer.parseInt(second);
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }

        return expression;
    }
}