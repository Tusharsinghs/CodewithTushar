public class BuySellStockTabulation {
    static int f(int day[]) {
        int n = day.length;
        int dp[][] = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    profit = Math.max(-day[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);

                } else {
                    profit = Math.max(day[ind] + dp[ind + 1][1], 0 + dp[ind + 1][0]);

                }
                dp[ind][buy] = profit;
            }

        }
        return dp[0][1];

    }

    public static void main(String[] args) {
        int d[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(f(d));
    }

}
