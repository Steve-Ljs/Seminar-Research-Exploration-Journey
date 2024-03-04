```
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too. 
You need to find the shortest such subarray and output its length.
Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=. 
```

```c++
//一开始想到的，比较慢
class Solution 
{
public:
	int findUnsortedSubarray(vector<int>& nums) 
	{
		vector<int> temp(nums);
		sort(temp.begin(), temp.end());

		if (temp == nums)
		{
			return 0;
		}

		int result = nums.size();
		int lo = 0, hi = nums.size() - 1;

		while (nums[lo] == temp[lo])
		{
			++lo;
			--result;
		}
		while (nums[hi] == temp[hi])
		{
			--hi;
			--result;
		}

		return result;
	}
};
```

```c++
#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>
using namespace std;




class Solution 
{
public:
	int findUnsortedSubarray(vector<int>& nums) 
	{
		int n = nums.size();
		int start = INT_MAX, end = INT_MIN;
		int maxVal = nums[0], minVal = nums[n - 1];
		//经过循环，maxVal为数组中最大一个，end表示此元素左边有比他大的
		for (int i = 1; i < n; i++) 
		{
			if (nums[i] < maxVal) 
			{
				end = i;
			}
			maxVal = max(maxVal, nums[i]);
		}
		for (int i = n - 2; i >= 0; i--) 
		{
			if (nums[i] > minVal) 
			{
				start = i;
			}
			minVal = min(minVal, nums[i]);
		}
		if (start == INT_MAX || end == INT_MIN) 
		{
			return 0;
		}
		else 
		{
			return end - start + 1;
		}
	}
};

```
