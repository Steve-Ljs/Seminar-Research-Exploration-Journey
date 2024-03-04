```
给定非空的整数数组，返回k个最常见的元素。

例1：
输入： nums = [1,1,1,2,2,3]，k = 2 
输出：[1,2]

例2：
输入： nums = [1]，k = 1 
输出：[1]
注意：

你可以假设ķ始终是有效的，1个≤ ķ <=独特元素的数量
算法的时间复杂度必须优于O（n log n），其中n是数组的大小。
```
```c++
class Solution 
{
public:
	vector<int> topKFrequent(vector<int>& nums, int k) 
	{
		vector<int> result;
		unordered_map<int, int> nums_count;
		for (auto i : nums)
		{
			++nums_count[i];
		}
		vector<pair<int, int>> vec;
		for (auto m : nums_count)
		{
			vec.push_back(make_pair(m.first, m.second));
		}
		sort(vec.begin(), vec.end(), [](pair<int, int> a, pair<int, int> b){return a.second > b.second; });
		for (auto m : vec)
		{
			if (result.size() < k)
				result.push_back(m.first);
			else
				break;
		}
		return result;
	}
};
```
