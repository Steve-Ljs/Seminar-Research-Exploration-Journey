```
您将获得不同面额的硬币和总金额。编写一个函数来计算构成该数量所需的最少数量的硬币。如果这笔钱不能由任何硬币组合弥补，则退货-1。

例1：

输入： coins = [1, 2, 5]，amount = 11
输出：3 
说明： 11 = 5 + 5 + 1
例2：

输入： coins = [2]，amount = 3
输出： -1
注意：
您可以假设您拥有无限数量的每种硬币。
```

```c++
class Solution
{
public:
	int coinChange(vector<int>& coins, int amount)
	{
		//最极端情况是coins里面有1,所以设置最大所需钱币数量为amount+1
		//这样，即使找的全由1分的硬币组成也不慌
		//dp[i]就代表了有i块钱时，要找的硬币数量
		vector<int> dp(amount + 1, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; ++i)
		{
			for (int j = 0; j < coins.size(); ++j)
			{
				if (coins[j] <= i)//要找的单个硬币的数值肯定要小于dp当前的amount
				{
					//coins[j]已经代表了一枚硬币，再加上i - coins[j]时的钱币所需的coins
					dp[i] = min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];//如果没有得找那么返回-1
	}
};
```
