package offer;

public class Demo63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int N = prices.length;
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < N; i++) {
            int temp = buy;
            buy = Math.max(-prices[i], buy);
            sell = Math.max(prices[i] + temp, sell);
        }
        return sell;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int N = prices.length;
        int[] buy = new int[N];
        int[] sell = new int[N];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < N; i++) {
            buy[i] = Math.max(-prices[i], buy[i - 1]);
            sell[i] = Math.max(prices[i] + buy[i - 1], sell[i - 1]);
        }
        return sell[N - 1];
    }
}
