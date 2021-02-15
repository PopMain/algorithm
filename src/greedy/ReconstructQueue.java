package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 */
public class ReconstructQueue {

    public static void main(String[] args) {
        int[][]  result = reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] +" , " + result[i][1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
               return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });

        List<int[]> queue = new ArrayList<>();
        for (int i = 0 ; i < people.length; i++) {
            queue.add(people[i][1], people[i]);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
