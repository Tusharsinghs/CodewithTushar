import java.util.Stack;

public class LongestValidParentheses {
    static int f(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
                if (!stk.isEmpty()) {
                    result = Math.max(result, i - stk.peek());
                } else {
                    stk.push(i);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "(()())((";
        System.out.println(f(s));

    }
}
