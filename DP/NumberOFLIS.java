import java.util.*;

public class NumberOFLIS {
    public static int findNumberOfLIS(int n, int[] arr) {
        int dp[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                    cnt[i] = cnt[j];
                } else if (arr[i] > arr[j] && dp[j] + 1 == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int nos = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi)
                nos += cnt[i];
        }
        return nos;
    }

    public static void main(String[] args) {
        int a[] = { 50, 3, 90, 60, 80 };
        int n = a.length;
        System.out.println(findNumberOfLIS(n, a));
    }

}
