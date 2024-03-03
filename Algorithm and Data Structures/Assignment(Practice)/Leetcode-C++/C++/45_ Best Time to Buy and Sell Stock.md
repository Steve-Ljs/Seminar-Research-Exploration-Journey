```
假设您有一个数组，其中第i 个元素是第i天给定股票的价格。

如果您只被允许完成最多一笔交易（即买入并卖出一股股票），请设计一个算法来查找最大利润。

请注意，在购买之前不能出售股票。

例1：

输入： [7,1,5,3,6,4]
 输出： 5
 说明：在第2天买入（价格= 1）并在第5天卖出（价格= 6），利润= 6-1 = 5。
             不是7-1 = 6，因为售价需要大于购买价格。
例2：

输入： [7,6,4,3,1]
 输出： 0
 说明：在这种情况下，没有进行任何交易，即最大利润= 0。
```

```c++
class Solution 
{
public:
	int maxProfit(vector<int>& prices) 
	{
		if (prices.empty()) return 0;
		int n = prices.size();
		vector<int> left_min(n);
		vector<int> right_max(n);
		left_min[0] = prices[0];
		right_max[n - 1] = prices[n - 1];
		for (int i = 1; i != n; ++i)
			left_min[i] = min(left_min[i - 1], prices[i]);
		for (int i = n - 2; i >= 0; --i)
			right_max[i] = max(right_max[i + 1], prices[i]);
		int max_get = 0;
		for (int i = 0; i != n; ++i)
			max_get = max(max_get, right_max[i] - left_min[i]);
		return max_get;
	}
};
```
