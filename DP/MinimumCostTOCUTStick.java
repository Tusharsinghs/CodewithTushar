import java.util.*;

public class MinimumCostTOCUTStick {
    static int f(int i, int j, int newarr[]) {
        if (i > j)
            return 0;
        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = newarr[j + 1] - newarr[i - 1] + f(i, ind - 1, newarr) + f(ind + 1, j, newarr);
            mini = Math.min(mini, cost);
        }
        return mini;
    }

    public static int cost(int n, int c, int cuts[]) {
        int newarr[] = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            newarr[i] = cuts[i - 1];

        }
        newarr[n + 1] = n;
        newarr[0] = 0;
        Arrays.sort(newarr);
        return f(1, c, newarr);
    }

    public static void main(String[] args) {
        int a[] = { 3, 5, 1, 4 };
        int c = a.length;
        int n = 7;
        System.out.println(cost(n, c, a));
    }

}
