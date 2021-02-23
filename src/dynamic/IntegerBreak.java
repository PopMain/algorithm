package dynamic;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class IntegerBreak {

    public static void main(String[] args) {

    }

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i<=n; i++) {
            for (int j = 1; j <= i -1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j*(i -j)));
            }
        }
        return dp[n];
    }
}
