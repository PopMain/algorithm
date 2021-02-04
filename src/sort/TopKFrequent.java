package sort;


import util.Utils;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[] {5,2,5,3,5,3,1,1,3}, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> bucket = new HashMap<>(nums.length);
        for (int i : nums) {
            if (bucket.containsKey(i)) {
                bucket.put(i, bucket.get(i) + 1);
            } else {
                bucket.put(i, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        bucket.entrySet().forEach(integerIntegerEntry -> {
            list.add(integerIntegerEntry);
        });

        int len = list.size();
        int beginIndex = len / 2 - 1;
        int endIndex = len - 1;
        for (int i = beginIndex; i >= 0; i--) {
            justHeap(list, i, endIndex);
        }

        int j = 0;
        int[] result = new int[k];
        result[0] = list.get(0).getKey();
        for (int i = len - 1; i >= 0; i--) {
            Collections.swap(list, 0, i);
            if (j >= k) {
                break;
            }
            result[j] = list.get(len - 1 - j).getKey();
            j++;
            if (i > 0) {
                justHeap(list, 0, i - 1);
            }
        }
        return result;
    }

    private static void justHeap(List<Map.Entry<Integer, Integer>> inputs, int i, int end) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = left;
        if (left > end) {
            return;
        }
        if (right <= end && inputs.get(right).getValue() > inputs.get(left).getValue()) {
            largest = right;
        }
        if (inputs.get(largest).getValue() > inputs.get(i).getValue()) {
            Collections.swap(inputs, largest, i);
            justHeap(inputs, largest, end);
        }
    }
}
