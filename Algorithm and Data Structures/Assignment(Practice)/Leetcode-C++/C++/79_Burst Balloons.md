```
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes 相邻.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
```

```c++
/*
[3,1,5,8]第一步:
0    0    0    0    0    0
0    3    0    0    0    0
0    0    15   0    0    0
0    0    0    40   0    0
0    0    0    0    40   0
0    0    0    0    0    0

len=2:
0    0    0    0    0    0
0    3    30   0    0    0
0    0    15   135  0    0
0    0    0    40   48   0
0    0    0    0    40   0
0    0    0    0    0    0

最后:
0    0    0    0    0    0
0    3    30   159  167  0
0    0    15   135  159  0
0    0    0    40   48   0
0    0    0    0    40   0
0    0    0    0    0    0
*/
class Solution 
{
public:
	int maxCoins(vector<int>& nums) 
	{
		int n = nums.size();
		nums.insert(nums.begin(), 1);
		nums.push_back(1);
		vector<vector<int>> dp(n+2, vector<int>(n+2, 0));//以现在数组的大小
		//dp[left][right]是我们可以从左到右获得的最大硬币。注意当left> right时，它为0
		for (int len = 1; len <= n; ++len)//len是子区间长度
			for (int left = 1; left <= n - len + 1; ++left) //因为长度的制约导致left的范围有所改变
			{
				int right = left + len - 1;
				for (int k = left; k <= right; ++k)//dp[left][right]是我们可以从左到右获得的最大硬币。注意当left> right时，它为0
					dp[left][right] = max(dp[left][right], nums[left - 1] * nums[k] * nums[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
				//k是最后一个弹出去的,所以乘left-1,right+1
				//所以总的来说就是,计算先把[left,k-1]弹出的报酬加上,[k+1,right]弹出的报酬加上,把k弹出的报酬 的最大值
			}
		return dp[1][n];//因为插入了一个1,所以left=1,right=n时提供的硬币最多
	}
};
```
