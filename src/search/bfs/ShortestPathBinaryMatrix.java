package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 */
public class ShortestPathBinaryMatrix {

    public static void main(String[]  args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,0,0}, {1,0,0}}));
    }

    private static int[][] direction = {{0, 1}, {1, 1} , {1, -1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1} };
    private static int  row, col;

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        row = grid.length;
        col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
        Queue<int[]> pos = new LinkedList<>(); // 维护当前移动1能走到的位置坐标
        grid[0][0] = 1; // 起始长度1
        pos.add(new int[]{0, 0});
        while (!pos.isEmpty() && grid[row - 1][col -1] == 0) {
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]]; // 当前点的路径长度
            for (int i = 0; i < 8; i++) {
                int newX = xy[0] + direction[i][0];
                int newY=  xy[1] + direction[i][1];
                if (inGrid(newX, newY) && grid[newX][newY] == 0) {
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1; // 下个点的路径长度要加1
                }
            }
        }
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1]; //如果最后终点的值还是0，说明没有到达的路径
    }

    public static boolean inGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
