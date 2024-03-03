package demo01_50;

public class Demo22
{
    /*
    开始旋转的那一层左上角是matrix[lo][lo],左下角matrix[hi][lo],
    右上角是matrix[lo][hi],右下角是matrix[hi][hi]
     */
    public void rotate(int[][] matrix)
    {
        int lo = 0, hi = matrix.length - 1;
        while(lo<hi)//lo==hi时,待旋转的只有1个元素
        {
            for (int i = 0; i < hi - lo; i++)
            {
                int temp=matrix[lo+i][hi];//右上
                matrix[lo+i][hi]=matrix[lo][lo + i];//右上
                matrix[lo][lo + i]=matrix[hi-i][lo];//左上
                matrix[hi-i][lo]=matrix[hi][hi-i];//左下
                matrix[hi][hi-i]=temp;//右下
            }
            ++lo;
            --hi;
        }
    }

    public static void main(String[] args)
    {
        int n = 4;
        int[][] matrix = new int[n][n];
        int count=0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = ++count;
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        new Demo22().rotate(matrix);
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
