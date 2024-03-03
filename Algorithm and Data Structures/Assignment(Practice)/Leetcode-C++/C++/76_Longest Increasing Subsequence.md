```
给定未排序的整数数组，找到最长的增加子序列的长度。

例：

输入： [10,9,2,5,3,7,101,18]
输出： 4 
 说明：增长最长的子序列是[2,3,7,101]，因此长度为4。
注意：

可能有多个LIS组合，只需要您返回长度。
您的算法应该以O（n 2）复杂度运行。
跟进：你能把它提高到O（n log n）时间复杂度吗？
```
```c++
/*
result:
[10]
[9]
[2]
[2,5]
[2,3]
[2,3,7]
[2,3,7,101]
[2,3,7,18]
*/
class Solution 
{
public:
	int lengthOfLIS(vector<int>& nums) 
	{
		vector<int> result;
		for (int i = 0; i != nums.size(); ++i) 
		{
			//返回[first, last)中的第一个大于等于值val的位置
			auto it = lower_bound(result.begin(), result.end(), nums[i]);
			if (it == result.end()) 
				result.push_back(nums[i]);
			else 
				*it = nums[i];
		}
		return result.size();
	}
};
```
