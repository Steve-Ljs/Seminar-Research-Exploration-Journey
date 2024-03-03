```
假设您有一个数组，其中第i 个元素是第i天给定股票的价格。

设计算法以找到最大利润。您可以通过以下限制完成任意数量的交易（即，多次买入并卖出一股股票）：

您不得同时进行多笔交易（即，您必须在再次购买之前卖出股票）。
在您出售股票后，您无法在第二天购买股票。（即冷却1天）
Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
```

```c++
//o(n)
/*
令sell[i] 表示第i天未持股时，获得的最大利润，buy[i]表示第i天持有股票时，获得的最大利润.
对于sell[i]，最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是今天卖了股票，所以状态转移方程如下：
sell[i] = max{ sell[i - 1], buy[i - 1] + prices[i] }
对于buy[i]，最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天卖了股票，今天买了股票，
因为 cooldown 只能隔天交易，所以今天买股票要追溯到前天的状态。状态转移方程如下：
buy[i] = max{buy[i-1], sell[i-2] - prices[i]}
最终我们要求的结果是sell[n - 1]，表示最后一天结束时，手里没有股票时的最大利润。
这个算法的空间复杂度是O(n)，不过由于sell[i]仅仅依赖前一项，buy[i]仅仅依赖前两项，所以可以优化到O(1)
*/
class Solution
{
public:
	int maxProfit(vector<int>& prices)
	{
		if (prices.size() < 2) return 0;
		int n = prices.size();
		vector<int> buy(n, 0), sell(n, 0);
		buy[0] = -prices[0];
		for (int i = 1; i < n; ++i)
		{
			sell[i] = max(buy[i - 1] + prices[i], sell[i - 1]);
			if (i == 1)
				buy[i] = max(buy[0],-prices[1]);
			else
				buy[i] = max(sell[i - 2] - prices[i], buy[i - 1]);
		}
		return sell[n-1];
	}
};
```

```c++
//o(1)
class Solution 
{
public:
	int maxProfit(vector<int>& prices) 
	{
		int buy(INT_MIN), sell(0), prev_sell(0), prev_buy;//开始肯定要买,所以初始值无穷小
		for (int price : prices) 
		{
			prev_buy = buy;
			buy = max(prev_sell - price, buy);
			prev_sell = sell;
			sell = max(prev_buy + price, sell);
		}
		return sell;
	}
};
```
