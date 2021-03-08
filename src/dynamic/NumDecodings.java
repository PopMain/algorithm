package dynamic;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
