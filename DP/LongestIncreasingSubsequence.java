import java.util.*;

public class LongestIncreasingSubsequence {
    static int f(int[] value, int ind, int prev_ind, int n, int dp[][]) {
        if (ind == n)
            return 0;

        int take = Integer.MIN_VALUE;
        if (dp[ind][prev_ind + 1] != -1)
            return dp[ind][prev_ind];
        int nottake = 0 + f(value, ind + 1, prev_ind, n, dp);
        if (prev_ind == -1 || value[ind] > value[prev_ind]) {
            take = 1 + f(value, ind + 1, ind, n, dp);
        }
        return dp[ind][prev_ind + 1] = Math.max(nottake, take);

    }

    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 0, 3, 5, 18, 4 };
        int n = arr.length;
        int dp[][] = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(f(arr, 0, -1, n, dp));
    }

}
