package hot;

public class Demo121
{
    public int maxProfit(int[] prices)
    {
        int N = prices.length;
        if (N == 0) return 0;
        int buy=-prices[0],sell=0,result = 0;
        for (int i = 1; i < N; i++)
        {
            sell = Math.max(0, prices[i] + buy);
            buy = Math.max(-prices[i], buy);
            result = Math.max(result, sell);
        }
        return result;
    }
    public int maxProfit1(int[] prices)
    {
        int N = prices.length;
        if (N == 0)
        {
            return 0;
        }
        int[] buy = new int[N];
        int[] sell = new int[N];
        int result = 0;

        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < N; i++)
        {
            buy[i] = Math.max(-prices[i], buy[i - 1]);
            //look,是+,不是-,因为buy[i]是负数
            sell[i] = Math.max(0, prices[i] + buy[i - 1]);
            result = Math.max(result, sell[i]);
        }
        return result;
    }
}
