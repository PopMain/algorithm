package search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PacificAtlantic {

    private static int[][] test ={
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14},
            {52,53,54,55,56,57,58,59,60,61,62,63,64,15},
            {51,96,97,98,99,100,101,102,103,104,105,106,65,16},
            {50,95,132,133,134,135,136,137,138,139,140,107,66,17},
            {49,94,131,160,161,162,163,164,165,166,141,108,67,18},
            {48,93,130,159,180,181,182,183,184,167,142,109,68,19},
            {47,92,129,158,179,192,193,194,185,168,143,110,69,20},
            {46,91,128,157,178,191,196,195,186,169,144,111,70,21},
            {45,90,127,156,177,190,189,188,187,170,145,112,71,22},
            {44,89,126,155,176,175,174,173,172,171,146,113,72,23},
            {43,88,125,154,153,152,151,150,149,148,147,114,73,24},
            {42,87,124,123,122,121,120,119,118,117,116,115,74,25},
            {41,86,85,84,83,82,81,80,79,78,77,76,75,26},
            {40,39,38,37,36,35,34,33,32,31,30,29,28,27}};

    public static void main(String[] args) {
      List<List<Integer>> result = pacificAtlantic(test);
      result.forEach((List<Integer> item)->{
          item.forEach((i -> {
              System.out.print(i+"  ");
          }));
          System.out.println("");
      });
    }

    private static int row, col;

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        row = matrix.length;
        col = matrix[0].length;
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int dpsResult = dps(matrix, i, j);
//                System.out.println(i+ ", " + j + " : " + Integer.toBinaryString(dpsResult));
                if((dpsResult & 0b0011) > 0 && (dpsResult & 0b1100) > 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    result.add(item);
                }
                for (int m = 0; m < row; m++) {
                    for (int n = 0; n < col; n++) {
                        dp[m][n] = -1;
                    }
                }
            }
        }
        return result;
    }

    private static int top = 0b1000;
    private static int left = 0b0100;
    private static int right = 0b0010;
    private static int bottom = 0b0001;
    private static int[][]dp;


    private static int dps(int[][] matrix, int i, int j) {
        int result = 0b0000;
        if (i <= 0) {
            result |= top;
        }
        if (i >= row - 1) {
            result |= bottom;
        }
        if (j <= 0) {
            result |= left;
        }
        if (j >= col - 1) {
            result |= right;
        }

        if (j - 1 >= 0 && j < col && matrix[i][j-1] != -1 && matrix[i][j-1] <= matrix[i][j]) {
            if (dp[i][j-1] != -1) {
                result |= dp[i][j-1];
            } else {
                int curTemp = matrix[i][j];
                matrix[i][j] = -1;
                int nextResult = dps(matrix, i, j - 1);
                result |= nextResult;
                dp[i][j-1] = nextResult;
                matrix[i][j] = curTemp;
            }
        }
        if (j + 1 < col  && j < col  && matrix[i][j + 1] != -1 && matrix[i][j + 1] <= matrix[i][j]) {
            if (dp[i][j + 1] != -1) {
                result |= dp[i][j + 1];
            } else {
                int curTemp = matrix[i][j];
                matrix[i][j] = -1;
                int nextResult = dps(matrix, i, j + 1);
                result |= nextResult;
                dp[i][j+1] = nextResult;
                matrix[i][j] = curTemp;
            }
        }
        if (i - 1 >= 0 && i < row && matrix[i - 1][j] != -1 && matrix[i - 1][j] <= matrix[i][j]) {
            if (dp[i-1][j] != -1) {
                result |= dp[i-1][j];
            } else {
                int curTemp = matrix[i][j];
                matrix[i][j] = -1;
                int nextResult = dps(matrix, i - 1, j);
                result |= nextResult;
                dp[i-1][j] = nextResult;
                matrix[i][j] = curTemp;
            }
        }
        if (i + 1 < row && i >= 0 && matrix[i + 1][j] != -1 && matrix[i + 1][j] <=  matrix[i][j]) {
            if (dp[i+1][j] != -1) {
                result |= dp[i+1][j];
            } else {
                int curTemp = matrix[i][j];
                matrix[i][j] = -1;
                int nextResult = dps(matrix, i + 1, j);
                result |= nextResult;
                dp[i+1][j] = nextResult;
                matrix[i][j] = curTemp;
            }
        }
        dp[i][j] = result;
        return result;
    }

    // 能向上或者向左流向太平洋
    private static boolean dpsFlowToPacificOcean(int[][] matrix, int i, int j) {
         if (i < 0 || j < 0) {
             return true;
         }
         boolean canTopFlow = true;
         if (i - 1 >= 0) {
             if (matrix[i][j] < matrix[i-1][j]) {
                 canTopFlow = false;
             }
         }
         boolean canLeftFlow = true;
         if (j - 1 >= 0) {
             if (matrix[i][j-1] > matrix[i][j]) {
                 canLeftFlow = false;
             }
         }
         if (!canLeftFlow && !canTopFlow) {
             return false;
         } else {
             return dpsFlowToPacificOcean(matrix, i, j-1) || dpsFlowToPacificOcean(matrix, i-1 , j);
         }
    }

    // 能向上或者向左流向大西洋
    private static boolean dpsFlowToAtlanticOcean(int[][] matrix, int i, int j) {
        if (i >= row || j >= col) {
            return true;
        }
        boolean canBottomFlow = true;
        if (i + 1 < row) {
            if (matrix[i][j] < matrix[i+1][j]) {
                canBottomFlow = false;
            }
        }
        boolean canRightFlow = true;
        if (j + 1 < col) {
            if (matrix[i][j+1] > matrix[i][j]) {
                canRightFlow = false;
            }
        }
        if (!canBottomFlow && !canRightFlow) {
            return false;
        } else {
            return dpsFlowToAtlanticOcean(matrix, i, j + 1) || dpsFlowToAtlanticOcean(matrix, i + 1 , j);
        }
    }
}
