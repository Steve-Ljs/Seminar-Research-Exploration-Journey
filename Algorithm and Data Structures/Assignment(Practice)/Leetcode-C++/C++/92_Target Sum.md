```
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol. 
Find out how many ways to assign symbols to make sum of integers equal to target S. 
Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:
The length of the given array is positive and will not exceed 20. 
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
```

```c++
#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<numeric>
#include<unordered_map>

using namespace std;

/*//暴力破解 很慢
class Solution 
{
public:
	int findTargetSumWays(vector<int>& nums, int S) 
	{
		return find(0, nums, S);
	}
	int find(int p, vector<int>& nums, long long sum) 
	{
		if (p == nums.size())
			return sum == 0;
		return find(p + 1, nums, sum + nums[p]) + find(p + 1, nums, sum - nums[p]);
	}
};*/

/*
The recursive solution is very slow, because its runtime is exponential

The original problem statement is equivalent to:
Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

Let P be the positive subset and N be the negative subset
For example:
Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

Then let's see how this can be converted to a subset sum problem:

				  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
					   2 * sum(P) = target + sum(nums)

So the original problem has been converted to a subset sum problem as follows:
Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

Note that the above formula has proved that target + sum(nums) must be even
We can use that fact to quickly identify inputs that do not have a solution
*/
class Solution 
{
public:
	int findTargetSumWays(vector<int>& nums, int S) 
	{
		//#include<numeric>
		int sum = accumulate(nums.begin(), nums.end(), 0);
		//if not even,will not have result,return 0
		//find (s+sum)/2,so>>1
		return sum < S || (S + sum) & 1 ? 0 : subsetSum(nums, (S + sum) >> 1);
	}
	//s is sum(P)
	/*int subsetSum(vector<int>& nums, int s) 
	{
		//dp[s] mean how many ways up to s(also sum(P))
		vector<int> dp(s + 1, 0);
		dp[0] = 1;
		for (int n : nums)
		{
			for (int i = s; i >= n; i--)
			{
				dp[i] += dp[i - n];
			}
		}
		return dp[s];
	}*/
	int subsetSum(vector<int>& nums, int S) 
	{
		vector<vector<int>> dp(nums.size() + 1, vector<int>(S + 1, 0));
		//假设有0个元素，那么他们有一种方式累加到0
		dp[0][0] = 1;

		//初始化列，假如元素值不是0，那么累加到0的方式和上一个的一样
		//如果是0，则累加到0的方式是元素少一个的乘2
		for (int i = 1; i <= nums.size(); ++i) 
		{
			if (nums[i - 1] == 0)
				dp[i][0] = dp[i - 1][0] * 2;
			else
				dp[i][0] = dp[i - 1][0];
		}
		//记录有多少种累加的方式能达到S
		for (int i = 1; i <= nums.size(); ++i) 
		{
			for (int j = 1; j <= S; ++j) 
			{
				if (j >= nums[i - 1])
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];//多加上了一个假如上一行减去nums[i-1]的叠加方式
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[nums.size()][S];
	}
};

int main()
{
	vector<int> nums = { 1,2,3 };
	int S = 0;
	Solution s;
	int result = s.findTargetSumWays(nums, S);
	cout << result << endl;
}
```
