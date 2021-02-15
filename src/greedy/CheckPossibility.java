package greedy;


import java.util.Arrays;

/**
 * 判断一个数组是否能只修改一个数就成为非递减数组。
 */
public class CheckPossibility {

    public static void main(String[] args) {
        int[] input = new int[]{5,7,1,8};
        boolean result = checkPossibility(input);
        System.out.println(result + " : " + Arrays.toString(input));
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
           if (nums[i] < nums[i-1]) {
               if (i - 2 >= 0 && nums[i-2] > nums[i]) {
                   nums[i] = nums[i-1];
               } else {
                   nums[i-1] = nums[i];
               }
               count--;
               if(count < 0) {
                   return false;
               }
           }
        }
        return true;
    }
}
