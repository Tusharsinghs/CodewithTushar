//LEETCODE PROBLEM Number of Zero-Filled Subarrays.
public class NoOfZeroesFilledSubarray {
    static int ZeroesFilled(int nums[]) {
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                j = i + 1;
            }
            res += i - j + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 0, 0, 2, 0, 0 };
        System.out.println(ZeroesFilled(nums));

    }

}
