package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 *
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] array = new int[] {31, 55, 57, 67, 70, 60, 12, 44, 20, 56, 58, 45, 29, 10};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void bucketSort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        int minValue = input[0];
        int maxValue = input[0];

        for (int i = 0; i < input.length; i++) {
            if (input[i] < minValue) {
                minValue = input[i];
            }
            if (input[i] > maxValue) {
                maxValue = input[i];
            }
        }
        int bucketNum = (maxValue - minValue) / 10 + 1;
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 1; i <= bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }

        for (int i = 0; i < input.length; i++) {
            int index = indexFor(input[i], minValue, 10);
            bucketList.get(index).add(input[i]);
        }
        List<Integer> bucket = null;
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            bucket = bucketList.get(i);
            insertSort(bucket);
            for (int v : bucket) {
                input[index++] = v;
            }
        }
    }

    private static int indexFor(int value, int min, int gap) {
        return (value - min) / gap;
    }

    private static void insertSort(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (input.get(j - 1) > input.get(j)) {
                    input.set(j, input.get(j - 1) + input.get(j));
                    input.set(j - 1, input.get(j) - input.get(j - 1));
                    input.set(j, input.get(j) - input.get(j - 1));
                }
            }
        }
    }


}
