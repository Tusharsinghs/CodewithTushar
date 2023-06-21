import java.util.*;

public class MaximumSumIncreasingSubsequence {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int i, j, max = 0;
        int msis[] = new int[n];

        /*
         * Initialize msis values
         * for all indexes
         */
        for (i = 0; i < n; i++)
            msis[i] = rack.get(i);

        /*
         * Compute maximum sum values
         * in bottom up manner
         */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (rack.get(i) > rack.get(j) &&
                        msis[i] < msis[j] + rack.get(i))
                    msis[i] = msis[j] + rack.get(i);

        /*
         * Pick maximum of all
         * msis values
         */
        for (i = 0; i < n; i++)
            if (max < msis[i])
                max = msis[i];

        return max;

        // Write your code here.
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(1);
        arr.add(2);
        arr.add(8);
        int n = arr.size();
        System.out.println(maxIncreasingDumbbellsSum(arr, n));
    }
}