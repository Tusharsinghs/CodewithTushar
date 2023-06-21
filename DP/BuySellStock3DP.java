public class BuySellStock3DP {
    static int f(int prices[], int buy, int ind, int cap) {
        int n = prices.length;
        int profit = 0;
        if (ind == n)
            return 0;
        if (cap == 0)
            return 0;
        if (buy == 1) {
            profit = Math.max(-prices[ind] + f(prices, 0, ind + 1, cap), 0 + f(prices, 1, ind + 1, cap));

        } else {
            profit = Math.max(prices[ind] + f(prices, 1, ind + 1, cap - 1), 0 + f(prices, 0, ind + 1, cap));
        }
        return profit;

    }

    public static void main(String[] args) {
        int day[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(f(day, 1, 0, 2));
    }

}
