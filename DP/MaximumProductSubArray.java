import java.util.ArrayList;

public class MaximumProductSubArray {
    static int f(ArrayList<Integer> arr, int n) {
        int result = arr.get(0);
        for (int i = 0; i < n; i++) {
            int mul = arr.get(i);
            for (int j = i + 1; j < n; j++) {
                mul *= arr.get(j);
                result = Math.max(result, mul);
            }
            result = Math.max(result, mul);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(3);
        ans.add(5);
        ans.add(-2);

        ans.add(-4);
        int n = ans.size();
        System.out.println(f(ans, n));
    }

}
