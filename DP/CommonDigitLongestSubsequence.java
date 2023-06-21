import java.util.*;

public class CommonDigitLongestSubsequence {
    public static int commonDigitLongestSubsequence(int[] arr) {
        int n = arr.length;
        int len = 1;
        int tmp;
        int i, j, d;
        int dp[] = new int[10];
        int cnt[] = new int[10];
        int locmax;
        tmp = arr[0];
        while (tmp > 0) {
            dp[tmp % 10] = 1;
            tmp /= 10;

        }
        for (i = 1; i < n; i++) {
            tmp = arr[i];
            locmax = 1;
            Arrays.fill(cnt, 0);
            while (tmp > 0) {
                cnt[tmp % 10] = 1;
                tmp /= 10;

            }
            for (d = 0; d <= 9; d++) {
                if (cnt[d] == 1) {
                    dp[d]++;
                    locmax = Math.max(locmax, dp[d]);

                }
            }
            for (d = 0; d <= 9; d++) {
                if (cnt[d] == 1) {
                    dp[d] = locmax;
                }
            }
            len = Math.max(len, locmax);
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 122, 77, 92, 55, 69, 98 };
        System.out.println(commonDigitLongestSubsequence(arr));
    }
}