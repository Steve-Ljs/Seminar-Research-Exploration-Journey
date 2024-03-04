package hot;

public class Demo48
{
    public void rotate(int[][] matrix)
    {
        int lo = 0, hi = matrix.length - 1;
        while(lo<hi)
        {
            for (int i = 0; i < hi - lo; i++)
            {
                int temp=matrix[lo][lo+i];
                matrix[lo][lo + i] = matrix[hi - i][lo];
                matrix[hi - i][lo] = matrix[hi][hi - i];
                matrix[hi][hi - i] = matrix[lo + i][hi];
                matrix[lo + i][hi] = temp;
            }
            ++lo;
            --hi;
        }
    }
}
