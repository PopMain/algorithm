package search.dfs;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {


    
    static char[][] test =  {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}};

    public static void main(String[] args) {
        System.out.println(numIslands(test));
    }

    private static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int row, col;

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        int landNums = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isLand(grid, i, j)) landNums++;
            }
        }
        return landNums;
    }

    private static boolean isLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
            return false;
        }
        grid[i][j] = '0';
        for (int[] d: direction) {
            int newI = i + d[0], newJ = j + d[1];
            if (isLand(grid, newI, newJ)) {
                grid[newI][newJ] = '0';
            }
        }
        return true;
    }
}
