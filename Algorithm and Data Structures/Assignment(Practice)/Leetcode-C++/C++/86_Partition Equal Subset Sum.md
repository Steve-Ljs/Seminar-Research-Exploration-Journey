```
给定仅包含正整数的非空数组，查找是否可以将数组划分为两个子集，使得两个子集中的元素总和相等。

注意：

每个数组元素不会超过100。
阵列大小不会超过200。
 

例1：

输入：[1,5,11,5]

输出：true

说明：数组可以分区为[1,5,5]和[11]。
 

例2：

输入：[1,2,3,5]

输出：false

说明：无法将数组分区为相等的和子集。
```

```c++
class Solution 
{
public:
	bool canPartition(vector<int>& nums) 
	{
		//accumulate带有三个形参：头两个形参指定要累加的元素范围，第三个形参则是累加的初值 #include<numeric>
		int s = accumulate(nums.begin(), nums.end(), 0);
		if (s % 2 != 0) return false;
		int target = s / 2, now_sum = 0;
		int n = nums.size();
		vector<bool> used(n, false);
		now_sum = nums.back();
		used[n - 1] = true;
		return dfs(nums, used, target, now_sum, n - 1);
	}
	bool dfs(const vector<int> & nums, vector<bool> & used, const int target, int& sum, int n) 
	{
		if (sum == target) return true;
		for (int i = n; i >= 0; --i) 
		{
			if (used[i]) continue;
			if (sum + nums[i] > target) continue;
			used[i] = true;
			sum += nums[i];
			if (dfs(nums, used, target, sum, i - 1)) return true;
			else 
			{
				used[i] = false;
				sum -= nums[i];
			}
		}
		return false;
	}
};
```
