package demo51_100;

public class Demo70
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0) return false;
        int M = matrix.length, N = matrix[0].length;
        int i = 0, j = N - 1;

        while (i < M && j >= 0)
        {
            if (target < matrix[i][j]) --j;
            else if (target > matrix[i][j]) ++i;
            else return true;
        }

        return false;
    }
}
