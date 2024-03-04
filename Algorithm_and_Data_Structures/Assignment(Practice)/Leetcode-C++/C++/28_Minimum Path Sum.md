```
给定m x n网格填充非负数，找到从左上到右下的路径，这最小化了沿其路径的所有数字的总和。

注意：您只能在任何时间点向下或向右移动。

例：

输入：
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出： 7
 说明：因为路径1→3→1→1→1最小化总和。
 ```
 
 ```c++
 class Solution 
{
public:
	int minPathSum(vector<vector<int>>& grid) 
	{
		if (grid.empty()||grid[0].empty())
			return 0;
		int m = grid.size(), n = grid[0].size();
		vector<vector<int>> dp(grid);
		for (int i = 1; i != m; ++i)
		{
			dp[i][0] += dp[i - 1][0];
		}
		for (int j = 1; j != n; ++j)
		{
			dp[0][j] += dp[0][j - 1];
		}
		for (int i = 1; i != m; ++i)
		{
			for (int j = 1; j != n; ++j)
			{
				dp[i][j] += min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m - 1][n - 1];
	}
};
```
