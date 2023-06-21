import java.util.*;

public class MinimumFallingPathSum {
    static int f(int row, int col, int[][] edges, int dp[][]) {
        if (row < 0)
            return 0;
        if (col < 0 || col >= edges[0].length)
            return (int) (1e7);
        if (dp[row][col] != -1)
            return dp[row][col];
        int ans = edges[row][col]
                + Math.min(f(row - 1, col - 1, edges, dp),
                        Math.min(f(row - 1, col, edges, dp), f(row - 1, col + 1, edges, dp)));
        return dp[row][col] = ans;

    }

    static int MinimumSum(int[][] edges) {
        int row = edges.length;
        int col = edges[0].length;
        int dp[][] = new int[row][col];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);

        }
        int ans = Integer.MAX_VALUE;
        for (int column = 0; column < col; column++) {
            ans = Math.min(ans, f(row - 1, column, edges, dp));
        }
        return ans;
    }

    public static void main(String[] args) {
        int m[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(MinimumSum(m));
    }

}
