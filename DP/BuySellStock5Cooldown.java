
//Cooldown meaning we cannot buy just after sell in a day....
import java.util.*;

public class BuySellStock5Cooldown {
    static int f(int day[], int ind, int buy, int dp[][]) {
        int n = day.length;
        int profit = 0;
        if (ind >= n)
            return 0;
        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        if (buy == 1) {
            profit = Math.max(-day[ind] + f(day, ind + 1, 0, dp), 0 + f(day, ind + 1, 1, dp));

        } else {
            profit = Math.max(day[ind] + f(day, ind + 2, 1, dp), 0 + f(day, ind + 1, 0, dp));
        }
        return dp[ind][buy] = profit;
    }

    public static void main(String[] args) {
        int d[] = { 1, 2, 3, 0, 2 };
        int ind = d.length;
        int dp[][] = new int[ind][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(f(d, 0, 1, dp));
    }

}
