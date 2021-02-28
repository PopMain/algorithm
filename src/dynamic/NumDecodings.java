package dynamic;

public class NumDecodings {

    public static void main(String[] args) {
        System.out.print(numDecodings("110"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                //如果前一位不是1或者2,显然无法解码
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2') {
                    return 0;
                }
                dp[i] = i == 1 ? 1 : dp[i-2];
            } else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                // //如果前一位是1或者2
                dp[i] = i == 1 ? dp[i-1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length() - 1];
    }
}
