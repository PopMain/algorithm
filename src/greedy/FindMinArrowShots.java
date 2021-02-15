package greedy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
 * **/
public class FindMinArrowShots {

    public static void main(String[] args) {
        int result = findMinArrowShots(new int[][]{new int[]{-2147483646,-2147483645}, new int[]{2147483646,2147483647}});
        System.out.println(result);
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 先排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 贪心，假设所有的数组都没有交集，那么就需要points.length的剑
        int count = points.length;
        // 交集的区间的right
        int right=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= right) {
                // 有交集，count-1
                count--;
            } else {
                // 无交集，更新right值
                right = points[i][1];
            }
        }
        return count;
    }
}
