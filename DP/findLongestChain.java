import java.util.*;

public class findLongestChain {
    static int f(int[][] p) {
        Arrays.sort(p, (a, b) -> a[1] - b[1]);
        int count = 0, i = 0, n = p.length;
        while (i < n) {
            count++;
            int curend = p[i][i];
            while (i < n && p[i][0] <= curend)
                i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = { { 3, 4 }, { 1, 2 }, { 2, 3 } };
        System.out.println(f(pairs));

    }

}
