```
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

```c++
//自己实现的非递归方式
class Solution //12 ms
{
public:
	vector<vector<int>> permute(vector<int>& nums) 
	{
		vector<vector<int>> result;
		if (nums.empty())
			return result;
		sort(nums.begin(), nums.end());
		bool is_reverse = false;
		while (!is_reverse)//没有变成4321
		{
			result.push_back(nums);
			//找下一个排列
			int first = -1;
			for (int i = nums.size() - 1; i >= 0; --i)
			{
				if (i - 1 >= 0 && nums[i - 1] < nums[i])
				{
					first = i - 1;
					break;
				}
			}
			if (first == -1)//说明是倒序的了
				is_reverse = true;
			else
			{
				int second = -1;
				for (int i = nums.size() - 1; i >= 0; --i)
				{
					if (nums[i] > nums[first])
					{
						second = i;
						break;
					}
				}
				int temp = nums[first];
				nums[first] = nums[second];
				nums[second] = temp;
				reverse(nums.begin() + first + 1, nums.end());
			}
		}
		return result;
		//recursive(result,nums,0);
	}
};
```

```c++
//递归的方式
class Solution 
{
public:
	void recursive(vector<int>& nums, vector<vector<int>>& result, int n)
	{
		if (n == nums.size() - 1) 
		{
			result.push_back(nums);
			return;
		}
		for (int i = n; i < nums.size(); ++i) 
		{
			swap(nums[i], nums[n]);
			recursive(nums, result, n + 1);
			swap(nums[i], nums[n]);//避免对下一个产生影响
		}
	}
	vector<vector<int>> permute(vector<int>& nums) 
	{
		vector<vector<int>> result;
		recursive(nums, result, 0);
		return result;
	}
};
```
