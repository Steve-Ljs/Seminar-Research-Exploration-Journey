```
给定未排序的整数数组，找到最长连续元素序列的长度。

您的算法应该以O（n）复杂度运行。

例：

输入：  [100,4,200,1,3,2]
 输出： 4
 说明：最长的连续元素序列是[1, 2, 3, 4]。因此它的长度是4。
```

```c++
class Solution 
{
public:
	int longestConsecutive(vector<int>& nums) 
	{
		if (nums.empty()) return 0;
		sort(nums.begin(), nums.end());
		int longest = 1;
		int count = 0;
		for (int i = 1; i != nums.size(); ++i)
		{
			if (nums[i] == nums[i - 1] + 1)
				++count;
			else if (nums[i] != nums[i - 1])
				count = 0;
			longest = max(longest, count + 1);
		}
		return longest;
	}
};
```
