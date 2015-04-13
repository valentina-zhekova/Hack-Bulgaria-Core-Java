import java.util.ArrayList;

public class BracketsExpression {

    public static boolean isCorrect(String brackets) {
        ArrayList<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                stack.add('(');
            } else if (brackets.charAt(i) == ')') {
                if (stack.size() != 0) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(BracketsExpression.isCorrect("()()())))((())("));
        System.out.println(BracketsExpression.isCorrect("())(()"));
        System.out.println(BracketsExpression.isCorrect("((()(((()))(()))))"));
    }
}
