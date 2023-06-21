//At most K transactions are allowed in a day.........It is not cooldown problem.
public class BuySellStockCooldown {
    static int f(int prices[], int k) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][k + 1];
        int profit = 0;
        // for (int ind = 0; ind <= n - 1; ind++) {
        // for (int buy = 0; buy <= 1; buy++) {
        // dp[ind][buy][0] = 0;
        // }

        // }
        // for (int buy = 0; buy <= 1; buy++) {
        // for (int cap = 0; cap <= 2; cap++) {
        // dp[n][buy][cap] = 0;
        // }

        // }
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][0][cap], 0 + dp[ind + 1][1][cap]);

                    } else {
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind + 1][1][cap - 1], 0 + dp[ind + 1][0][cap]);
                    }
                    // dp[ind][buy][cap] = profit;

                }

            }
        }
        return dp[0][1][k];
    }

    public static void main(String[] args) {
        int day[] = { 3, 2, 6, 5, 0, 3 };
        int k = 2;
        System.out.println(f(day, k));
    }
}
