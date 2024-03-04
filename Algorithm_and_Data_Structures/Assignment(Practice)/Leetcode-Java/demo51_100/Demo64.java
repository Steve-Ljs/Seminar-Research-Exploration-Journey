package demo51_100;

public class Demo64
{
    //动态规划
    /*
    dp[i][j]代表最大的正方形边长
     */
    public int maximalSquare(char[][] matrix)
    {
        if (matrix.length == 0) return 0;
        int result = 0;
        int M = matrix.length, N = matrix[0].length;
        int[][] dp = new int[M + 1][N + 1];//为了不用再次初始化
        for (int i = 1; i <= M; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                if (matrix[i - 1][j - 1] == '1')
                {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }

    /*
    该方法太麻烦了
     */
    public int maximalSquare1(char[][] matrix)
    {
        if (matrix.length == 0) return 0;
        int M = matrix.length, N = matrix[0].length;
        int[] height = new int[N];
        int[] left = new int[N];
        int[] right = new int[N];

        for (int i = 0; i < N; i++)
        {
            right[i] = N;
        }

        int result = 0;
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (matrix[i][j] == '1') ++height[j];
                else height[j] = 0;
            }

            /*
            还得考虑他们的上面,因为如果是
            100
            100
            111
            这种情况,判断高度,左右都算正确的,但是实际是不对的
            所以left与right需要特殊的技巧
            */
            //如果为1时,left[j]为它左边的第一个1,为0时为0
            for (int j = 0, temp = 0; j < N; j++)
            {
                /*
                0111
                1111
                0001
                0111
                0111
                这一段if else为精髓所在,首先,如果j此处为0,那么height[j]肯定为0,所以left为什么值不会影响他
                left[j] = Math.max(temp,left[j]);
                第一重意思:如上面第一二行,虽然第二行temp=0,但是left[j](上一行的)为1,所以要缩短范围,到1
                这样就可以避免1上面空出0,但是还是计算的情况
                 */
                if (matrix[i][j] == '0')
                {
                    temp = j + 1;
                    left[j] = 0;
                }
                else
                {
                    left[j] = Math.max(temp, left[j]);
                }
            }

            //如果为1时,right[j]为它右边的空位
            for (int j = N - 1, temp = N; j >= 0; --j)
            {
                if (matrix[i][j] == '0')
                {
                    temp = j;
                    right[j] = N;
                }
                else
                {
                    right[j] = Math.min(right[j], temp);
                }

            }

            for (int j = 0; j < N; j++)
            {
                int n = Math.min(height[j], right[j] - left[j]);
                result = Math.max(result, n * n);
            }
        }
        return result;
    }
}
