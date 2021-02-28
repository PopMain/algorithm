package string;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.print(isAnagram("a", "b"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] chs = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            chs[t.charAt(i) - 'a']--;
        }

        for (int ch : chs) {
            if (ch != 0) {
                return false;
            }
        }
        return true;
    }
}
