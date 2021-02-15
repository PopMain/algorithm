package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 计算让一组区间不重叠所需要移除的区间个数。
 *
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] input = new int[][]{new int[]{1,100} , new int[]{11, 22}, new int[]{1,11}, new int[]{2, 12}};
        int result = eraseOverlapIntervals(input);
        System.out.println(result);
    }

    /**
     * 贪心
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        /**
         * 不重叠的个数count
         */
        int count = 1 ;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
     }
}
