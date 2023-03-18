public class Solver {
    public static void main(String[] args) {
        System.out.println(solve("(276 + (23 + (2 - 4)))"));
    }

    public static String solve(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.substring(i, i + 1).equals("(")) {
                for (int j = expression.length() - 1; j > i; j--) {
                    if (expression.charAt(j) == ')') {
                        String s = solve(expression.substring(i + 1, j));
                        expression = expression.substring(0, i) + s + expression.substring(j + 1, expression.length());
                        break;
                    }
                }

                break;

            }
        }
        
        return solve2(expression);
    }

    public static String solve2(String expression) {
        while (expression.contains("^")) {
            String first = ""; String second = "";
            int i = expression.indexOf("^"); int x = i - 2; int y = i + 2;
            while (x >= 0) {
                if (expression.charAt(x) == ' ') {
                    break;
                }
                first = expression.charAt(x) + first;
                x--;
            }

            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') {
                    break;
                }
                second = second + expression.charAt(y);
                y++;
            }

            int z = (int) Math.pow(Integer.parseInt(first), Integer.parseInt(second));
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }

        while (expression.contains("/")) {
            String first = ""; String second = "";
            int i = expression.indexOf("/"); int x = i - 2; int y = i + 2;
            while (x >= 0) {
                if (expression.charAt(x) == ' ') {
                    break;
                }
                first = expression.charAt(x) + first;
                x--;
            }

            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') {
                    break;
                }
                second = second + expression.charAt(y);
                y++;
            }

            int z = (int) Integer.parseInt(first) / Integer.parseInt(second);
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }

        while (expression.contains("*")) {
            String first = ""; String second = "";
            int i = expression.indexOf("*"); int x = i - 2; int y = i + 2;
            while (x >= 0) {
                if (expression.charAt(x) == ' ') {
                    break;
                }
                first = expression.charAt(x) + first;
                x--;
            }

            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') {
                    break;
                }
                second = second + expression.charAt(y);
                y++;
            }

            int z = (int) Integer.parseInt(first) * Integer.parseInt(second);
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }

        while (expression.contains("+")) {
            String first = ""; String second = "";
            int i = expression.indexOf("+"); int x = i - 2; int y = i + 2;
            while (x >= 0) {
                if (expression.charAt(x) == ' ') {
                    break;
                }
                first = expression.charAt(x) + first;
                x--;
            }

            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') {
                    break;
                }
                second = second + expression.charAt(y);
                y++;
            }

            int z = (int) Integer.parseInt(first) + Integer.parseInt(second);
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }

        while (expression.contains("-")) {
            String first = ""; String second = "";
            int i = expression.indexOf("-"); int x = i - 2; int y = i + 2;
            while (x >= 0) {
                if (expression.charAt(x) == ' ') {
                    break;
                }
                first = expression.charAt(x) + first;
                x--;
            }

            while (y < expression.length()) {
                if (expression.charAt(y) == ' ') {
                    break;
                }
                second = second + expression.charAt(y);
                y++;
            }

            int z = Integer.parseInt(first) - Integer.parseInt(second);
            expression = expression.substring(0, x + 1) + z + expression.substring(y, expression.length());
        }

        return expression;
    }
}