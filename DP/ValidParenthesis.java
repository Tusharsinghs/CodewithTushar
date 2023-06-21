public class ValidParenthesis {
    static boolean checkValidString(string s) {
        Stack<Integer> open, star;
        int len = s.length();
        for (int i = 0; s[i] != '\0'; i++) {
            if (s[i] == '(')
                open.push(i);
            else if (s[i] == '*')
                star.push(i);
            else {
                if (!open.empty())
                    open.pop();
                else if (!star.empty())
                    star.pop();
                else {
                    return false;
                }
            }
        }
        while (!open.empty()) {
            if (star.empty())
                return false;
            else if (open.top() < star.top()) {
                open.pop();
                star.pop();

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "*())";
        System.out.println(checkValidString(s));
    }
}