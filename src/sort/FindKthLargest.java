package sort;

import util.Utils;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 */
public class FindKthLargest {


    public static void main(String[] args) {
       int result = findKthLargest(new int[]{2,1}, 2);
       System.out.println(result);
    }


    /**
     * 使用堆排序
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            throw new IllegalArgumentException();
        }
        int len = nums.length;
        int beginIndex = len / 2 - 1;
        int endIndex = len - 1;
        for (int i = beginIndex; i >= 0; i--) {
            justHeap(nums, i, endIndex);
        }
        int j = 0;
        int lastNum = nums[0];
        for (int i = endIndex; i >= 0; i--) {
            Utils.swap(nums, 0, i);
            lastNum = nums[i];
            j++;
            if (j == k) {
                break;
            }
            if (i > 1) {
                justHeap(nums, 0, i - 1);
            }
        }
        return lastNum;
    }

    private static void justHeap(int[] inputs, int i, int end) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = left;
        if (left > end) {
            return;
        }
        if (right <= end && inputs[right] > inputs[left]) {
            largest = right;
        }
        if (inputs[largest] > inputs[i]) {
            Utils.swap(inputs, largest, i);
            justHeap(inputs, largest, end);
        }
    }
}
