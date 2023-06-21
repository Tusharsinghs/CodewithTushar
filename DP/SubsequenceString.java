public class SubsequenceString {
    static void func(String t, int i, int n, String s) {
        if (i == n) {
            System.out.println(t);
        } else {
            func(t, i + 1, n, s);
            t = t + s.charAt(i);
            func(t, i + 1, n, s);
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        func("", 0, s.length(), s);
    }
}