```
给定阵列nums的Ñ整数，是否有元件一，b，c ^在nums使得一个 + b + c ^ = 0？找到数组中所有唯一的三元组，它们的总和为零。

注意：

解决方案集不得包含重复的三元组。

例：

给定数组nums = [-1,0,1,2，-1，-4]，

解决方案集是：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

```c++
class Solution
{
public:
	vector<vector<int> > threeSum(vector<int> &nums)
	{
		vector<vector<int> > result;
		sort(nums.begin(), nums.end());
		for (int i = 0; i != nums.size(); ++i)
		{
				int target = -nums[i];
				int lo = i+1, hi = nums.size() - 1;
				while (lo < hi)
				{
					int sum = nums[lo]+nums[hi];
					if (target < sum)      --hi;
					else if (target > sum) ++lo;
					else
					{
						result.push_back({ nums[i],nums[lo],nums[hi] });
						while (lo != hi && nums[lo + 1] == nums[lo]) ++lo;
						while (lo != hi && nums[hi - 1] == nums[hi]) --hi;
						++lo;
					}
				}
			while (i + 1 != nums.size() && nums[i + 1] == nums[i]) ++i;
		}
		return result;
	}
};
```
