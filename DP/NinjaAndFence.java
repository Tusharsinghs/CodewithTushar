
//Paint the fence with K colours such that not more than two fence are of same color..
import java.util.*;

public class NinjaAndFence {
    static int mod = (int) Math.pow(10, 9) + 7;

    static int add(int a, int b) {
        return (a % mod + b % mod) % mod;
    }

    static int mul(int a, int b) {
        return (int) ((a % mod) * (long) 1L * b % mod) % mod;
    }

    static int f(int n, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        if (n == 1)
            return k;
        if (n == 2)
            return add(k, mul(k, k - 1));

        int ans = add(mul(f(n - 2, k), k - 1), mul(f(n - 1, k), k - 1));
        return ans;
    }

    static int solve(int n, int k, int dp[]) {
        int mod = (int) Math.pow(10, 9) + 7;
        if (n == 1)
            return k;
        if (n == 2)
            return add(k, mul(k, k - 1));
        if (dp[n] != -1)
            return dp[n];
        int ans = add(mul(solve(n - 2, k, dp), k - 1), mul(solve(n - 1, k, dp), k - 1));
        return dp[n] = ans;
    }

    public static int numberOfWays(int n, int k) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, k, dp);
        // Write your code here.
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(numberOfWays(n, k));
    }

}
