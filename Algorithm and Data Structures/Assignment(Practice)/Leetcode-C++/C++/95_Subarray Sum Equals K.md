```
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
```

```c++
#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

class Solution {
public:
	int subarraySum(vector<int>& nums, int k) 
	{
		int result = 0;
		if (nums.size() == 0)
			return result;
		unordered_map<int, int> dictionary;
		int sum = 0;
		for (int i = 0; i < nums.size(); ++i) 
		{
			sum += nums[i];
			if (sum == k)
				++result;
			//因为要是连续的子数列,sum-k如果能找到，就代表了子数列去掉前面某几个之和还能恰好得到k
			//则可以算上
			if (dictionary.count(sum - k))
				result += dictionary[sum - k];
			++dictionary[sum];
		}
		return result;
	}
};

int main()
{
	vector<int> nums = {1,3,3,4,7};
	int k = 7;
	Solution s;
	int result=s.subarraySum(nums, k);
	cout << result;
}
```
