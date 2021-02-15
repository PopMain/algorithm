package greedy;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 */
public class IsSubsequence {


    public static void main(String[] args) {
        boolean result = isSubsequence3("bcd", "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuubcd");
        System.out.println(result);
    }


    /**
     * 贪心+双指针
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.isEmpty() || s.length() > t.length()) {
            return false;
        }
        int slen = s.length();
        int tlen = t.length();
        int i = 0;
        int j = 0;
        while (i < slen && j < tlen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i>=slen;
    }

    /**
     * String#indexOf
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }


    /**
     * 动态规划: 时间换空间
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence3(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        //dp数组f[i][j]表示字符串t以i位置开始第一次出现字符j的位置
        int[][] f = new int[tLen + 1][26];
        for (int i = 0; i < 26; i++) {
            f[tLen][i] = -1;
        }
        //从后往前递推初始化dp数组
        for (int i = tLen - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i ;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int tIndex = 0;
        for (int i = 0; i < sLen; i++) {
            //f中没有s[i] 返回false
            if (f[tIndex][s.charAt(i) - 'a'] == -1) {
                return false;
            }
            //否则直接跳到f中s[i]第一次出现的位置之后一位
            tIndex = f[tIndex][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

}
