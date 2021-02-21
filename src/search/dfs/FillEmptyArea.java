package search.dfs;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，
 * 任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，
 * 或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class FillEmptyArea {

    static char[][] test = {
            {'O', 'X', 'X', 'O', 'X'},
            {'X', 'O', 'O', 'X', 'O'},
            {'X', 'O', 'X', 'O', 'X'},
            {'O', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'X', 'O'},
    };

    public static void main(String[] args) {
        solve(test);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println("  ");
        }
    }

    private static int row, col;

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 反向思维：边界的0向四个方向扩散遇到#（被访问过）X返回不再继续遍历搜索（不能被包围）
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1)
                    dfs(board, i, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }


    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        int left = i - 1;
        int top = j - 1;
        int right = i + 1;
        int bottom = j + 1;
        // 四个方向判断
        dfs(board, left, j);
        dfs(board, i, top);
        dfs(board, right, j);
        dfs(board, i, bottom);
    }
}
