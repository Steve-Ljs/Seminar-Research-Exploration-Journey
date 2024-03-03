```
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
```

```c++
class Solution
{
public:
	vector<int> productExceptSelf(vector<int>& nums)
	{
		int n = nums.size();
		vector<int> result(n, 1),left(n + 1, 1),right(n + 1, 1);
		for (int i = 0; i < n; ++i)
			left[i + 1] = left[i] * nums[i];
		for (int i = n - 1; i >= 0; --i)
			right[i] = right[i + 1] * nums[i];
		for (int i = 0; i < n; ++i)
			result[i] = left[i] * right[i + 1];
		return result;
	}
};
```
