```
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

```c++
class Solution 
{
public:
	int numTrees(int n) 
	{
		vector<int> dp(n+1);
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; ++i) //每个n的值
			for (int j = 1; j <= i; ++j) //dp(n) = F(1, n) + F(2, n) + ... + F(n, n) 把j=1,2,3..放在第一个
				dp[i] += dp[j - 1] * dp[i - j];//如果把j放在第一个,此时的数量等于左边的乘右边的
		return dp[n];
	}
};
```
