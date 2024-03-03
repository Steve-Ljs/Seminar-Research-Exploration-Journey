package demo01_50;

public class Demo45
{
    /*
    buy[i]=Math.min(buy[i-1],prices[i])
    sell[i]=prices[i]-buy[i-1]
    result=max(sell[i])
     */
    public int maxProfit(int[] prices)
    {
        if(prices==null || prices.length==0) return 0;
        int buy = prices[0],sell=0;
        int result = 0;
        for (int i = 1; i < prices.length; i++)
        {
            sell = prices[i] - buy;
            result = Math.max(result, sell);
            buy = Math.min(buy, prices[i]);
        }
        return result;
    }
}
