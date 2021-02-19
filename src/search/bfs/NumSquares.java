package search.bfs;

import java.util.*;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
 * 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 *
 *  [12] --step1---> [12-1=10, 12-4=8, 12-9=3] --step2--> [11-1=10, 11-4=7, 11-9=2, 8-1=7,8-4=4] --step3-->
 *  [10-1=9,10-4=6,10-9=1,4-1=3,4-4=0,,,,,]得0后说明已经找到路径step=3, 12-4-4-4=0
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        ArrayList<Integer> squareNums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            squareNums.add(i * i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);

        int step = 0;
        while (queue.size() > 0) {
            step += 1;
            Set<Integer> nextQueue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : squareNums) {
                    if (remainder.equals(square)) {
                        return step;
                    } else if (remainder < square) {
                        break;
                    } else {
                        nextQueue.add(remainder - square);
                    }
                }
            }
            queue = nextQueue;
        }
        return step;
    }

}
