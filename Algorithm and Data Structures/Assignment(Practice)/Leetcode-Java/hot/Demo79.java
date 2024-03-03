package hot;

public class Demo79
{
    public boolean exist(char[][] board, String word)
    {
        if (board.length == 0)
        {
            return false;
        }
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dfs(board, word, i, j, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index)
    {
        if (board[i][j] != word.charAt(index))
        {
            return false;
        }
        if (index == word.length() - 1)
        {
            return true;
        }

        char temp = board[i][j];
        //标记为已访问
        board[i][j] = '*';

        boolean result = false;

        if (i - 1 >= 0)
        {
            result = dfs(board, word, i - 1, j, index + 1);
        }
        if (i + 1 < board.length)
        {
            result = result || dfs(board, word, i + 1, j, index + 1);
        }
        if (j - 1 >= 0)
        {
            result = result || dfs(board, word, i, j - 1, index + 1);
        }
        if (j + 1 < board[0].length)
        {
            result = result || dfs(board, word, i, j + 1, index + 1);
        }
        //这次深搜结束,恢复
        board[i][j] = temp;
        return result;
    }
}
