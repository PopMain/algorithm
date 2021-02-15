package greedy;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int result = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0], max = nums[0];
        for (int i = 1 ; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

    /**
     * 动态规划
     * 这个会超出内存限制
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int j = 0 ; j < nums.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else if(i == j - 1) {
                    dp[i][j] = nums[i] + nums[j];
                } else {
                    dp[i][j] = nums[i] + nums[j] + dp[i + 1][j - 1];
                }
            }
        }
        int max = nums[0];
        for (int i = 0 ; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
                System.out.println("[" + i + "," + j + "] = " + dp[i][j]);
            }
        }
        return max;
    }
}
