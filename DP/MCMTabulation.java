public class MCMTabulation {
    static int MatrixMultiplication(int[] arr, int n) {
        int dp[][] = new int[n][n];
        for (int i = 1; i < n; i++)
            dp[i][i] = 0;
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 3, 2 };
        int n = arr.length;

        System.out.println(MatrixMultiplication(arr, n));
    }

}
