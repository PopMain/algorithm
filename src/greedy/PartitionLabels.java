package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {


    public static void main(String[] args) {
         List<Integer> res = partitionLabels("ababcbacadefegdehijhklij");
         for (Integer s : res) {
             System.out.print(s);
         }
    }

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
