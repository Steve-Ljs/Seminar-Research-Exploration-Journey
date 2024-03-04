package hot;

public class Demo70
{
    public int climbStairs(int n)
    {
        if(n==1 || n==2) return n;//正整数,不用考虑这么多

        int first = 1, second = 2;//初始化为爬1楼,2楼的方法数量
        for (int i = 3; i <= n; i++)//i代表楼梯数
        {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
