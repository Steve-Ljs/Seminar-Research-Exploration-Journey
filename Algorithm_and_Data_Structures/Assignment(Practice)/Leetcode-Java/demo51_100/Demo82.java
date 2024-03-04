package demo51_100;

public class Demo82
{
    /*
    基本思路是:第i个元素与第i个元素左移1位后的二进制位数只相差1位
    所以[i]=[i>>1]+i的末尾即被移出去的那个bit的值(0或者1)
    所以[i]=[i>>1]+i%2
    例如:11是1011,11左移1位为101,11的就是101与余数1的组合,101就是5,就是11/2
    所以通过动态规划,得到状态转移方程:P(x)=P(x/2)+(x mod 2)

    i>>1即为i/2     i&1即为i%2
     */
    public int[] countBits(int num)
    {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++)
        {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(9>>1);
    }
}
