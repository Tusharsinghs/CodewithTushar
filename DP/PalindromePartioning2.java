//Minimum no of partitions required so string is palindrome..
public class PalindromePartioning2 {
    static boolean isPalindrome(int ind, int j, String str) {
        while (ind < j) {
            if (str.charAt(ind) != str.charAt(j))
                return false;
            ind++;
            j--;
        }
        return true;
    }

    static int f(String str, int ind, int n) {
        if (ind == n)
            return 0;
        int mincost = Integer.MAX_VALUE;
        for (int j = ind; j < n; j++) {
            if (isPalindrome(ind, j, str)) {
                int cost = 1 + f(str, j + 1, n);
                mincost = Math.min(mincost, cost);
            }

        }
        return mincost;
    }

    public static int palindromePartitioning(String str) {
        int n = str.length();
        return f(str, 0, n) - 1;
        // Write your code here
    }

    public static void main(String[] args) {
        String s = "bababcbadcede";
        System.out.println(palindromePartitioning(s));
    }
}
