public class CoinGameWinnerwhereEveryPlayerhas3Choices {
    public static int coinGameWinner(int n, int a, int b) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0 && dp[i - 1] == 0) {
                dp[i] = 1;
            } else if (i - a >= 0 && dp[i - a] == 0) {
                dp[i] = 1;
            } else if (i - b >= 0 && dp[i - b] == 0) {
                dp[i] = 1;
            } else
                dp[i] = 0;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int a = 2;
        int b = 3;
        System.out.println(coinGameWinner(n, a, b));
    }

}
