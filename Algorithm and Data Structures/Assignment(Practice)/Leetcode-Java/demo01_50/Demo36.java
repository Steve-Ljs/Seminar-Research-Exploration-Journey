package demo01_50;

public class Demo36
{
    public int maximalRectangle(char[][] matrix)
    {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        for (int j = 0; j < n; j++)
        {
            right[j] = n;
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j] = height[j] + 1;
            }

            for (int j = 0, leftCount = 0; j < n; j++)
            {
                if (matrix[i][j] == '0')
                {
                    leftCount = j + 1;
                    left[j] = 0;
                } else
                {
                    left[j] = Math.max(leftCount, left[j]);
                }
            }

            for (int j = n - 1, rightCount = n; j >= 0; --j)
            {
                if (matrix[i][j] == '0')
                {
                    rightCount = j;
                    right[j] = n;
                } else
                {
                    right[j] = Math.min(rightCount, right[j]);
                }
            }

            for (int j = 0; j < n; j++)
            {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }

        return result;
    }
}
