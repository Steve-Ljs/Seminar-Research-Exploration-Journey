package demo51_100;

import java.util.Arrays;

public class Demo80
{
    //递归方式,很快,但是不是很好理解
    private int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount)
    {
        Arrays.sort(coins);//因为需要从大的先取出,但是硬币数组不一定有序
        recursive(coins, amount, 0, coins.length-1);//coins.length - 1代表先从最大的面额的硬币开始
        return result==Integer.MAX_VALUE?-1:result;
    }
    //index代表将要抛出的硬币位置,count代表当前已经抛出的硬币数量,needAmount代表抛出硬币后还需要的金额数
    private void recursive(int[] coins, int needAmount, int count, int index)
    {
        if(needAmount==0)//必须在下面那个条件之前,因为必须判断此时的是否符合条件,再判断下一个是否符合条件
        {
            result = Math.min(result, count); return;
        }
        if(index<0) return;

        int k = needAmount / coins[index];//计算最大能投几个coins[index]面额的硬币
        //先尽量的多抛出更多的大金额硬币  count+k<result的剪枝
        for (int i = k; i >= 0 && count+k<result; i--)
        {
            /* 抛出k枚大的硬币后,再递归到下一次,抛出面额较小的index-1型号的硬币
            因为把大金额的硬币所有抛出情况都考虑了,所以不会有遗漏例如1,7,10这种情况的
            唯独剪枝了所需要硬币数已经大于已知result的了,result代表了能够组成的硬币最小数,这是贪心算法的优点所在
            例如刚刚开始就得到了result=1,那么会剪去后面所有的,只判断,而不再进入递归*/
            recursive(coins,needAmount-i*coins[index],count+i,index-1);
        }
    }

    /*//动态规划,但是很慢
    public int coinChange(int[] coins, int amount)
    {
        int[] bp = new int[amount + 1];

        for (int i = 1; i < amount+1; i++)
        {
            bp[i] = Integer.MAX_VALUE;//初始化为最大值
            for (int j = 0; j<coins.length; j++)//对于每个小于总金额的硬币
            {
                if(coins[j]<=i && bp[i - coins[j]]!=-1)
                {
                    bp[i] = Math.min(bp[i], bp[i - coins[j]] + 1);//找最小的硬币数
                }
            }
            if(bp[i]==Integer.MAX_VALUE) bp[i] = -1;
        }
        System.out.println(Arrays.toString(bp));
        return bp[amount];
    }
*/
    public static void main(String[] args)
    {
        int[] coins = {2, 5};
        new Demo80().coinChange(coins, 11);

    }
}
