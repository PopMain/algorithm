package dynamic;

/**
 * /**
 *  * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *  *
 *  * 说明：每次只能向下或者向右移动一步。
 *  */

public class MinPathSum {

    public static void main(String[] args){
        int[][] test = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int result = minPathSum(test);
        System.out.print(result);
    }


    static int row, col;
    public static int minPathSum(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int fromTop;
                int fromLeft;
                if (i > 0) {
                    fromTop = dp[i-1][j] + grid[i][j];
                } else {
                    fromTop = Integer.MAX_VALUE;
                }
                if (j > 0) {
                    fromLeft= dp[i][j-1] + grid[i][j];
                } else {
                    fromLeft = Integer.MAX_VALUE;
                }
                dp[i][j] = Math.min(fromLeft, fromTop);
            }
        }
        return dp[row-1][col-1];
    }
}
