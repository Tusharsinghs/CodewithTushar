//It har exponential time complexity so to reduce the time we follow memoization technique and DP ARRAY IS USED...
public class CountPalindromicSubsequence {
    static int f(String s, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (s.charAt(i) == s.charAt(j)) {
            return 1 + f(s, i + 1, j) + f(s, i, j - 1);
        } else {
            return f(s, i + 1, j) + f(s, i, j - 1) - f(s, i + 1, j - 1);
        }

    }

    public static int Count(String s) {
        int n = s.length();
        return f(s, 0, n - 1);
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Count(s));

    }

}
