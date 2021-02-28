package dynamic;

public class NumArray {

    public static void main(String[] args) {

    }

    int[] mSums;

    public NumArray(int[] nums) {
        mSums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                mSums[0] = nums[0];
                continue;
            }
            mSums[i] = mSums[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return mSums[j + 1] - mSums[i];
    }
}
