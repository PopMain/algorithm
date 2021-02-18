package divide;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1,4}, 4)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                result[0] = 0;
                result[1] = 0;
                return result;
            }
        }
        int len = nums.length;
        int left = 0, right = len - 1;
        int position = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                position = mid;
                break;
            }
        }
        if (position >= 0) {
            int start = position, end = position;
            while (true) {
                if (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                } else {
                    break;
                }
            }
            while (true) {
                if (end + 1 < len && nums[end + 1] == target) {
                    end++;
                } else {
                    break;
                }
            }
            result[0] = start;
            result[1] = end;
        }
        return result;
    }
}
