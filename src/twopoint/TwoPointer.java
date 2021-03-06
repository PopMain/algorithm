package twopoint;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针
 */
public class TwoPointer {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <=  5; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = node;
        }
        cur.next = null;
        ListNode re = reverseList(head);
        while (re != null) {
            System.out.print(re.val);
            re = re.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextTemp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextTemp;
        }
        return preNode;
    }

    /**
     匹配字典里最长单词
     **/
    public String findLongestWord(String s, List<String> d) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        String result = "";
        int curIndex = 0;
        for (String element: d) {
            int i = 0, j = 0;
            int elementLen = element.length();
            while (i < len && j < elementLen) {
                if (s.charAt(i) == element.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
                if (j >= element.length()) {
                    if (element.length() > result.length()
                            || (element.length() == result.length() && !isLetterBigger(element, result) )) {
                        result = element;
                    }
                }
            }
            curIndex++;
        }
        return result;
    }

    public static boolean isLetterBigger(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) > s2.charAt(j)) {
                return true;
            } else if (s1.charAt(i) < s2.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return false;
    }


    /**
     是否有环
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode step1 = head;
        ListNode step2 = head.next.next;
        while (step1 != null && step2 != null) {
            if (step1 == step2) {
                return true;
            }
            step1 = step1.next;
            if (step2.next == null) {
                return false;
            }
            step2 = step2.next.next;
        }
        return false;
    }

    /**
     合并数组：逆向，内存复杂度O（1）
     **/
    public static void mergeRevert(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = 0;
        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[m+n-1-k] = nums1[i];
                i--;
            } else {
                nums1[m+n-1-k] = nums2[j];
                j--;
            }
            k++;
        }
        while (i >= 0) {
            nums1[m+n-1-k] = nums1[i];
            i--;
            k++;
        }
        while (j >= 0) {
            nums1[m+n-1-k] = nums2[j];
            j--;
            k++;
        }
    }

    /**
     合并数组：正向
     **/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i= 0, j = 0;
        int[] merge = new int[m + n];
        int k = 0;
        while (i < m && j < n) {
            int nNum = nums1[i];
            int mNum = nums2[j];
            if (nNum <= mNum) {
                merge[k] = nNum;
                i++;
            } else {
                merge[k] = mNum;
                j++;
            }
            k++;
        }
        while (i<m) {
            merge[k] = nums1[i];
            i++;
            k++;
        }
        while (j<n) {
            merge[k] = nums2[j];
            j++;
            k++;
        }
        for (int index = 0; index < m + n; index++) {
            nums1[index] = merge[index];
        }
    }

    /**
     回文串
     **/
    public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 	subValidPalindrome(s, i + 1, j) || subValidPalindrome(s, i,j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean subValidPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     反转元音字母
     **/
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            if (isVowelsChar(chars[i]) && isVowelsChar(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (!isVowelsChar(chars[i])) {
                i++;
            } else {
                j--;
            }
        }
        return new String(chars);
    }

    private static boolean isVowelsChar(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    /**
     平方和
     **/
    public static boolean judgeSquareSum(int c) {
        double cSqrt = Math.sqrt(c);
        int i = 0, j = (int) cSqrt;
        while (i <= j) {
            int result = i * i + j * j;
            if (result == c) {
                return true;
            } else if (result < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /**
     两数和
     **/
    public static int[] twoSum(int[] numbers, int target) {
        if  (numbers == null || numbers.length < 2) {
            return null;
        }
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else  if (sum > target) {
                right--;
            } else  {
                left++;
            }
        }
        return null;
    }

    /**
     三数和
     **/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length < 3) {
            return result;
        }
        int len = nums.length;
        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 已经排好序了，如果nums[i]>0那么后面就肯定不能满足三数之和为0
            if (nums[i] > 0) {
                return result;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = len - 1;
            int target = - nums[i];
            // 双指针求两数值和
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    while (start < end && nums[start] == nums[start + 1]) {
                        // 跳过重复的数
                        start++;
                    }
                    start++;
                    while (end > start && nums[end] == nums[end - 1]) {
                        // 跳过重复的数
                        end--;
                    }
                    end--;
                } else if (sum < target) {
                    // 和太小，移动左指针
                    start++;
                } else {
                    // 和太大，引动右指针
                    end--;
                }
            }
        }

        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
