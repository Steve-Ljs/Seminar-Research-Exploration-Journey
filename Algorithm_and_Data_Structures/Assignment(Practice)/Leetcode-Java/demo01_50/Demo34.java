package demo01_50;

public class Demo34
{
    /*
    自己之前写的思路一样,但是超出了时间限制,好好感受下这个比较标准的
     */
    public boolean exist(char[][] board, String word)
    {
        if (board == null || board.length == 0) return false;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                //FBI warning,注意,如果是false,那么不应该返回,应该继续判断其他的,
                //所以第二个if语句不是多余的
                if(board[i][j]==word.charAt(0))
                    if(recursive(board, word, i, j, 0))
                        return true;
            }
        }
        return false;
    }

    private boolean recursive(char[][] board, String word, int i, int j, int begin)
    {
        if (begin == word.length()) return true;

        if (((i >= 0 && i < board.length) && (j >= 0 && j < board[0].length)) && board[i][j] == word.charAt(begin))
        {
            board[i][j] ='.';
            boolean flag=recursive(board, word, i + 1, j, begin + 1)
                    || recursive(board, word, i - 1, j, begin + 1)
                    || recursive(board, word, i, j + 1, begin + 1)
                    || recursive(board, word, i, j - 1, begin + 1);

            if(flag) return true;//找到了当然返回
            else board[i][j] =word.charAt(begin);//不然就应该回溯,留待下一个使用
        }
        return false;
    }

    public static void main(String[] args)
    {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s = "SEE";
        new Demo34().exist(board, s);
        System.out.println("");
    }
}
