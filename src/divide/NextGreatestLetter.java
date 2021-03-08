package divide;

public class NextGreatestLetter {


    /**
     * 你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
     *
     * 在比较时，字母是依序循环出现的。举个例子：
     *
     * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }


    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
}
