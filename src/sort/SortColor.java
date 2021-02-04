package sort;

import util.Utils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 *
 */
public class SortColor {

   public static void main(String[] args) {
       int[] input = new int[] {0,2,2,2,0,2,1,1};
       sortColorsTwoPointer(input);
       System.out.println(Arrays.toString(input));
   }


    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        Map<Integer, List<Integer>> map = new HashMap(8);
        map.put(0, new ArrayList<>());
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        for (Integer i : nums) {
            map.get(i).add(i);
        }
        AtomicInteger j = new AtomicInteger();
        map.entrySet().forEach( integerListEntry -> {
            for (Integer integer : integerListEntry.getValue()) {
                nums[j.get()] = integer;
                j.getAndIncrement();
            }
        });
    }

    public static void sortColorsTwoPointer(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (right >= left && nums[right] == 2) {
            right--;
        }
        while (left < right && nums[left] == 0) {
            left++;
        }
        for (int i = left; i <= right; i++) {
            if (nums[i]==0) {
                Utils.swap(nums, i, left);
                left++;
            }
            if (nums[i] == 2) {
                Utils.swap(nums, i, right);
                right--;
                // i位置和right交换，交换的数有可能是0，i需要减1，重新判断是否为0
                i--;
            }
        }
    }
}
