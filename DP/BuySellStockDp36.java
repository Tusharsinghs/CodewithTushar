import java.util.Arrays;

public class BuySellStockDp36 {
    static int f(int day[], int ind, int buy, int dp[][]) {
        int n = day.length;
        int profit = 0;
        if (ind == n)
            return 0;
        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        if (buy == 1) {
            profit = Math.max(-day[ind] + f(day, ind + 1, 0, dp), 0 + f(day, ind + 1, 1, dp));

        } else {
            profit = Math.max(day[ind] + f(day, ind + 1, 1, dp), 0 + f(day, ind + 1, 0, dp));

        }
        return dp[ind][buy] = profit;
    }

    public static void main(String[] args) {
        int d[] = { 7, 1, 5, 3, 6, 4 };
        int ind = d.length;
        int dp[][] = new int[ind][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(f(d, 0, 1, dp));
    }
}