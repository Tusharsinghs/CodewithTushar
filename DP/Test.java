import java.util.*;

public class Test {
    static int f(int i, int j, ArrayDeque<Integer> arr) {
        if (i > j)
            return 0;
        int mini = Integer.MIN_VALUE;
        for (int ind = i; ind < j; ind++) {
            int cost = arr.getFirst(i - 1) * arr.getFirst(ind) * arr.getFirst(j + 1) + f(i, ind - 1, arr) + f(ind + 1, j, arr);
            mini = Math.min(mini, cost);

        }
        return mini;
    }

    public static int maxCoins(int a[]) {
        List<Integer> ans =Arrays.asList(a);
        ArrayDeque<Integer>ad=new ArrayDeque<>(ans);
        ad.addFirst(1);
        ad.addLast(1);
        return f(1, ad.size() - 1, ad);

        // Write your code here..
    }

    public static void main(String[] args) {
        int a[] = { 7, 1, 8 };
        System.out.println(maxCoins(a));
    }

}
