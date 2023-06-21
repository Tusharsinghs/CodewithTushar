import java.util.*;

public class PrintLIS {
    static int f(int n, int[] arr) {
        int lastindex = 0;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int hash[] = new int[n];

        int maxi = 1;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastindex = i;
            }

        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> rev = new ArrayList<Integer>();
        while (hash[lastindex] != lastindex) {
            lastindex = hash[lastindex];
            ans.add(arr[lastindex]);
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            rev.add(ans.get(i));
        }
        for (int i = 0; i < rev.size(); i++) {
            System.out.print(rev.get(i));
        }
        return maxi;

    }

    public static void main(String[] args) {
        int a[] = { 5, 4, 11, 1, 16, 8 };
        int n = a.length;
        System.out.println(f(n - 1, a));
    }

}
