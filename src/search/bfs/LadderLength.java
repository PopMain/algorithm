package search.bfs;

import java.util.*;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 *
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LadderLength {

    public static void main(String[] args) {
        String startWord = "hit";
        String endWord = "cog";
        String[] wordArray = {"hot","dot","tog","cog"};
        ArrayList<String> wordList = new ArrayList<String>();
        Collections.addAll(wordList, wordArray);
        System.out.println(ladderLength(startWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int curSize = queue.size();
            for (int q = 0; q < curSize; q++) {
                // 遍历当前路径队列
                StringBuilder sb = new StringBuilder(queue.poll());
                for (int i = 0; i < sb.length(); i++) {
                    for (int j = 'a'; j <= 'z'; j++) {
                        char ch = (char) j;
                        String re = String.valueOf(ch);
                        StringBuilder temp = new StringBuilder(sb.toString());
                        temp.replace(i, i + 1, re);
                        // 逐个替换字符，判断是否和endWord相等，或者是否在wordSet里，如果在说明存在路径，队列添加nextWord
                        String nextWord = temp.toString();
                        if (endWord.equals(nextWord)) {
                            return step;
                        }
                        if (wordSet.contains(nextWord) && !queue.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.add(nextWord);
                            visited.add(nextWord);
                        }

                    }
                }
            }
        }
        return 0;
    }


}
