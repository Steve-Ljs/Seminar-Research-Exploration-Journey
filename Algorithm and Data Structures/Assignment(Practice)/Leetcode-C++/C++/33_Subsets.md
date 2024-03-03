```
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

```c++
class Solution 
{
public:
	vector<vector<int>> subsets(vector<int>& nums) 
	{
		vector<vector<int>> results;
		vector<int> result;
		recursive(nums, 0, result, results);
		return results;
	}
private:
	void recursive(vector<int>& nums, int i, vector<int>& result, vector<vector<int>>& results) 
	{
		results.push_back(result);//第一步先加入空的
		for (int j = i; j < nums.size(); ++j) 
		{
			result.push_back(nums[j]);
			recursive(nums, j + 1, result, results);
			result.pop_back();
		}
	}
};
```
