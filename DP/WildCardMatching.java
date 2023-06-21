public class WildCardMatching {
    static boolean f(String s1, String s2, int i, int j) {
        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
            return false;
        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++) {
                if (s1.charAt(ii) != '*')
                    return false;
            }
            return true;
        }
        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
            return f(s1, s2, i - 1, j - 1);
        if (s1.charAt(i) == '*')
            return f(s1, s2, i - 1, j) || f(s1, s2, i, j - 1);
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ebc";
        String s2 = "abc";
        int n = s1.length();
        int m = s2.length();
        System.out.println(f(s1, s2, n - 1, m - 1));
    }

}
