
//DP on Partitions.......Tough Problem
import java.util.*;

public class MatrixChainMultiplication {
    static int f(int i, int j, int[] arr,int dp[][]) {
        if (i == j)
            return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        for (int k = i; k < j; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + f(i, k, arr,dp) + f(k + 1, j, arr,dp);
            mini = Math.min(mini, steps);

        }
        return dp[i][j]=mini;
    }

    static int MatrixMultiplication(int[] arr, int n) {
        int dp[][] = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(1, n - 1, arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 3, 2 };
        int n = arr.length;

        System.out.println(MatrixMultiplication(arr, n));
    }

}
