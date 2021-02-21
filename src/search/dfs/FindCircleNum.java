package search.dfs;

public class FindCircleNum {

    
    private static int[][] test = {{1,1,0},{1,1,0},{0,0,1}};

    public static void main(String[] args) {
        System.out.println(findCircleNum(test));
    }


    private static int row, col;

    public static int findCircleNum(int[][] M) {
        if (M == null && M.length == 0) {
            return 0;
        }
        row = M.length;
        col = M[0].length;
        int friendsCircleCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i != j && M[i][j] == 1) {
                    dfs(M, i, j);
                    friendsCircleCount++;
                }
            }
        }
        return friendsCircleCount;
    }

    private static void dfs(int[][] M, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || M[i][j] == 0) {
            return;
        }
        for (int m = 0; m < row; m++) {
            if (m != j && M[m][j] == 1) {
                M[m][j] = 0;
                dfs(M, m, j);
            }
        }
        for (int n = 0; n < col; n++) {
            if (i != n && M[i][n] == 1) {
                M[i][n] = 0;
                dfs(M, i, n);
            }
        }
    }
}
