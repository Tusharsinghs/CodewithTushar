import java.util.*;

public class LongestBitonicSubsequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        int dp1[] = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && 1 + dp1[j] > dp1[i]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }
        int dp2[] = new int[n];
        Arrays.fill(dp2, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i] && 1 + dp2[j] > dp2[i]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
        // Write your code here.
    }

    public static void main(String[] args) {
        int a[] = { 1, 11, 2, 10, 4, 5, 2, 1 };
        int n = a.length;
        System.out.println(longestBitonicSequence(a, n));
    }
}
